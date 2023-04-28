module react;

class Reactor(T)
{
    abstract class Cell
    {
        protected T pvalue;
        protected ComputeCell[] dependents;

        @property
        public T value()
        {
            return this.pvalue;
        }

        @property
        void value(T v)
        {
            this.changeAndForward(v, this);
        }

        void changeAndForward(T v, Cell originalSource)
        {
            this.pvalue = v;
            foreach (outputCell; dependents)
            {
                outputCell.changeEvent(v, this, originalSource);
            }
        }

        protected void registerComputeCell(ComputeCell cell)
        {
            this.dependents ~= cell;
        }

        Cell[] getDependencies()
        {
            return [];
        }
    }

    class InputCell : Cell
    {
        alias value = Cell.value;

        this(T value)
        {
            this.pvalue = value;
        }

    }

    class ComputeCell : Cell
    {
        int arity;
        T function(T) applyFn1;
        T function(T, T) applyFn2;
        bool[void delegate(T)] callbacks;

        //Handling two dependencies (arity == 2)
        private bool modificationOngoing = false; //flag to delay the update of a cell until all its dependencies has changed if they are not independent 
        private bool[] dependenciesChanged;
        private Cell[] dependencies;
        private T[] dependenciesValues;

        this(Cell dependency, T function(T) fun)
        {
            this.arity = 1;
            this.applyFn1 = fun;
            this.pvalue = fun(dependency.value());
            dependency.registerComputeCell(this);
            dependencies ~= dependency;

        }

        this(Cell dependency, Cell otherDependency, T function(T, T) fun)
        {
            this.arity = 2;
            this.applyFn2 = fun;
            this.pvalue = fun(dependency.value(), otherDependency.value());
            dependency.registerComputeCell(this);
            otherDependency.registerComputeCell(this);

            dependencies ~= dependency;
            dependencies ~= otherDependency;
            dependenciesValues ~= dependency.value();
            dependenciesValues ~= otherDependency.value();
            dependenciesChanged ~= false;
            dependenciesChanged ~= false;
        }

        auto addCallback(void delegate(T) callback) nothrow @safe
        {
            callbacks[callback] = true;
            return () { callbacks.remove(callback); return; };
        }

        void changeEvent(T newValue, Cell inputCell, Cell originalSource)
        {
            if (this.arity == 1)
            {
                T previousValue = this.value;
                T newComputedValue = this.applyFn1(newValue);
                if (previousValue != newComputedValue)
                {
                    foreach (callback, _; this.callbacks)
                    {
                        callback(newComputedValue);
                    }
                }
                this.changeAndForward(newComputedValue, originalSource);

            }
            else if (this.arity == 2)
            {
                import std.algorithm.searching : countUntil, all, canFind;

                long depPos = countUntil(this.dependencies, inputCell);
                dependenciesValues[depPos] = newValue;
                dependenciesChanged[depPos] = true;

                bool independentDepencies = !this.dependencies.all!(dep => dep.getDependencies()
                        .canFind(originalSource));

                if (independentDepencies || (modificationOngoing && all(dependenciesChanged)))
                {
                    //reset to default value
                    modificationOngoing = false;
                    dependenciesChanged = [false, false];

                    T previousValue = this.value;
                    T newComputedValue = this.applyFn2(dependenciesValues[0], dependenciesValues[1]);
                    if (previousValue != newComputedValue)
                    {
                        foreach (callback, _; this.callbacks)
                        {
                            callback(newComputedValue);
                        }
                    }
                    this.changeAndForward(newComputedValue, originalSource);
                }
                else
                {
                    modificationOngoing = true;
                }
            }
            else
            {
                assert(0);
            }
        }

        override Cell[] getDependencies()
        {
            Cell[] dependenciesResult;
            foreach (depency; this.dependencies)
            {
                dependenciesResult ~= depency;
                dependenciesResult ~= depency.getDependencies();
            }
            return dependenciesResult;
        }
    }
}

unittest
{

    {
        // input cells have a value
        Reactor!(int) r;
        auto input = r.new InputCell(10);

        assert(input.value == 10);
    }

    {
        // an input cell's value can be set
        Reactor!(int) r;
        auto input = r.new InputCell(4);

        input.value = 20;
        assert(input.value == 20);
    }
    {
        // compute cells calculate initial value
        Reactor!(int) r;
        auto input = r.new InputCell(1);
        auto output = r.new ComputeCell(input, (int x) => x + 1);

        assert(output.value == 2);
    }

    {
        // compute cells take inputs in the right order
        Reactor!(int) r;
        auto one = r.new InputCell(1);
        auto two = r.new InputCell(2);
        auto output = r.new ComputeCell(one, two, (int x, int y) => x + y * 10);

        assert(output.value == 21);
    }

    {
        // compute cells update value when dependencies are changed
        Reactor!(int) r;
        auto input = r.new InputCell(1);
        auto output = r.new ComputeCell(input, (int x) => x + 1);

        input.value = 3;
        assert(output.value == 4);
    }

    {
        // compute cells fire callbacks
        Reactor!(int) r;
        auto input = r.new InputCell(1);
        auto output = r.new ComputeCell(input, (int x) => x + 1);
        int[] vals;

        output.addCallback((int x) { vals ~= [x]; return; });

        input.value = 3;
        assert(vals.length == 1);
        assert(vals[0] == 4);
    }

    {
        // compute cells only fire on change
        Reactor!(int) r;
        auto input = r.new InputCell(1);
        auto output = r.new ComputeCell(input, (int x) => x < 3 ? 111 : 222);
        int[] vals;

        output.addCallback((int x) { vals ~= [x]; return; });

        input.value = 2;
        assert(vals.length == 0);
        input.value = 3;
        assert(vals.length == 1);
        assert(vals[0] == 222);
    }

    {
        // callbacks can be added and removed
        Reactor!(int) r;
        auto input = r.new InputCell(11);
        auto output = r.new ComputeCell(input, (int x) => x + 1);
        int[] vals1;
        int[] vals2;
        int[] vals3;

        auto cancel1 = output.addCallback((int x) { vals1 ~= [x]; return; });
        output.addCallback((int x) { vals2 ~= [x]; return; });

        input.value = 31;

        cancel1();
        output.addCallback((int x) { vals3 ~= [x]; return; });

        input.value = 41;

        assert(vals1.length == 1);
        assert(vals1[0] == 32);
        assert(vals2.length == 2);
        assert(vals2[0] == 32);
        assert(vals2[1] == 42);
        assert(vals3.length == 1);
        assert(vals3[0] == 42);
    }
    {
        // removing a callback multiple times doesn't interfere with other callbacks
        Reactor!(int) r;
        auto input = r.new InputCell(1);
        auto output = r.new ComputeCell(input, (int x) => x + 1);
        int[] vals1;
        int[] vals2;

        void delegate() cancel1 = output.addCallback((int x) {
            vals1 ~= [x];
            return;
        });
        output.addCallback((int x) { vals2 ~= [x]; return; });
        foreach (i; 0 .. 10)
        {
            cancel1();
        }

        input.value = 2;

        assert(vals1.length == 0);
        assert(vals2.length == 1);
        assert(vals2[0] == 3);
    }

    {
        // callbacks should only be called once even if multiple dependencies change
        Reactor!(int) r;
        auto input = r.new InputCell(1);
        auto plusOne = r.new ComputeCell(input, (int x) => x + 1);
        auto minusOne1 = r.new ComputeCell(input, (int x) => x - 1);
        auto minusOne2 = r.new ComputeCell(minusOne1, (int x) => x - 1);
        auto output = r.new ComputeCell(plusOne, minusOne2, (int x, int y) => x * y);
        int[] vals;

        output.addCallback((int x) { vals ~= [x]; return; });
        input.value = 4;
        assert(vals.length == 1);
        assert(vals[0] == 10);
    }
    {
        // callbacks should not be called if dependencies change but output value doesn't change
        Reactor!(int) r;
        auto input = r.new InputCell(1);
        auto plusOne = r.new ComputeCell(input, (int x) => x + 1);
        auto minusOne = r.new ComputeCell(input, (int x) => x - 1);
        auto alwaysTwo = r.new ComputeCell(plusOne, minusOne, (int x, int y) => x - y);
        int[] vals;

        alwaysTwo.addCallback((int x) { vals ~= [x]; return; });

        foreach (i; 0 .. 10)
        {
            input.value = i;
        }

        assert(vals.length == 0);
    }

    {
        // This is a digital logic circuit called an adder:
        // https://en.wikipedia.org/wiki/Adder_(electronics)
        Reactor!(bool) r;
        auto a = r.new InputCell(false);
        auto b = r.new InputCell(false);
        auto carryIn = r.new InputCell(false);

        auto aXorB = r.new ComputeCell(a, b, (bool x, bool y) => x != y);
        auto sum = r.new ComputeCell(aXorB, carryIn, (bool x, bool y) => x != y);

        auto aXorBAndCin = r.new ComputeCell(aXorB, carryIn, (bool x, bool y) => x && y);
        auto aAndB = r.new ComputeCell(a, b, (bool x, bool y) => x && y);
        auto carryOut = r.new ComputeCell(aXorBAndCin, aAndB, (bool x, bool y) => x || y);

        bool[5][] tests = [
            //            inputs,     expected
            //   a,     b,   cin,  cout,   sum
            [false, false, false, false, false],
            [false, false, true, false, true],
            [false, true, false, false, true],
            [false, true, true, true, false],
            [true, false, false, false, true],
            [true, false, true, true, false],
            [true, true, false, true, false],
            [true, true, true, true, true],
        ];

        foreach (i, test; tests)
        {
            a.value = test[0];
            b.value = test[1];
            carryIn.value = test[2];

            assert(carryOut.value == test[3]);
            assert(sum.value == test[4]);
        }
    }

}
