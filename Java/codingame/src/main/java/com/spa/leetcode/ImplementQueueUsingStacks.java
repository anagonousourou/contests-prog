package com.spa.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class ImplementQueueUsingStacks {


    //https://leetcode.com/problems/implement-queue-using-stacks/?envType=daily-question&envId=2024-01-29
    private static class MyQueue {

        Deque<Integer> pushStack = new LinkedList<>();
        Deque<Integer> peekStack = new LinkedList<>();

        public MyQueue() {

        }

        public void push(int x) {
            pushStack.add(x);
        }

        public int pop() {
            if (peekStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    peekStack.add(pushStack.pop());
                }
            }
            return peekStack.pop();
        }

        public int peek() {
            if (peekStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    peekStack.add(pushStack.pop());
                }
            }
            return peekStack.peek();
        }

        public boolean empty() {
            return peekStack.isEmpty() && pushStack.isEmpty();
        }
    }
}
