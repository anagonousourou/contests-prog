package com.spa.leetcode.easy;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintInOrder {

    // https://leetcode.com/problems/print-in-order/submissions/1689586312/
    class Foo {

        private final AtomicInteger counter = new AtomicInteger(0);
        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            counter.incrementAndGet();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (counter.get() == 0){

            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            counter.incrementAndGet();
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (counter.get() != 2){

            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
