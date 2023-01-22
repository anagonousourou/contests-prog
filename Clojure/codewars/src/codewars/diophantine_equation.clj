(ns codewars.diophantine-equation
  "In mathematics, a Diophantine equation is a polynomial equation,
  usually with two or more unknowns, such that only the integer solutions are sought or studied.

  In this kata we want to find all integers x, y (x >= 0, y >= 0) solutions of a diophantine equation of the form:

  x2 - 4 * y2 = n

  (where the unknowns are x and y, and n is a given positive number) in decreasing order of the positive xi.

  Hint:
  x² - 4 * y² = (x - 2*y) * (x + 2*y)

  From the hint we have
  x - 2y = a and x + 2y = b => 2x = a + b and 4y = b - a
                            => x = (a + b) / 2 and y = (b - a) / 4
  ")



(defn- pos-or-zero? [x]
  (or (pos? x) (zero? x)))

(defn- get-divisors-pairs
  "
  This function find the all divisor pairs (the order within a pair does not matter).
  http://mathandmultimedia.com/2012/06/02/determining-primes-through-square-root/
  The Formal Proof
  Conjecture: Every composite number has a proper factor less than or equal to its square root.\n\n
  Proof: We use proof by contradiction.  Suppose n is composite.
  Then, we can write n = ab, where a and b are both between 1 and n.
  If both a > \\sqrt{n} and b> \\sqrt{n}, then (a)(b) > (\\sqrt{n})(\\sqrt{n}) which means that ab > n.
  This contradicts our assumption that ab = n. Hence, at least one of a, b is less than or equal to \\sqrt{n}.
  That is, if n is composite, then n has a prime factor p \\le \\sqrt{n}.
  "
  [n]
    (->> (range 1 (-> n (Math/sqrt) (inc) (int)))
         (reduce (fn [result-coll, x] (if (zero? (mod n x)) (conj result-coll [x, (quot n x)]) result-coll)), [])
         )
    )

(defn- test-divisors-pairs [existing-solution, [a , b]]
  (let [x (quot (+ a b) 2)
        y (quot (- b a) 4)
        a-prime (- x (* 2 y))
        b-prime (+ x (* 2 y))
        a-and-b-are-solution (and (= a-prime a) (= b-prime b))
        x-and-y-are-positive-integers (every? pos-or-zero? [x, y])
        ]
    (if (and  a-and-b-are-solution x-and-y-are-positive-integers)
          (conj existing-solution [x, y])
            existing-solution)
  ))


(defn sol-equa [n]
  (->> (get-divisors-pairs n)
       (reduce test-divisors-pairs [])
       (sort-by first >)
       ))