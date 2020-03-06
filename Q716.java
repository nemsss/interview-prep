package leetcode.easy;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by cenumah on 2020-01-23
 */
public class Q716 {

    public static void main(String[] args) {

        MaxStack maxStack = new MaxStack();
        maxStack.push(5);
        maxStack.push(1);
        maxStack.push(5);

        System.out.println(maxStack.top());
        System.out.println(maxStack.popMax());
        System.out.println(maxStack.top());
        System.out.println(maxStack.peekMax());
        System.out.println(maxStack.pop());
        System.out.println(maxStack.top());

        maxStack = new MaxStack();
        maxStack.push(5);
        maxStack.push(1);
        maxStack.push(-5);

        System.out.println(maxStack.popMax());
        System.out.println(maxStack.popMax());
        System.out.println(maxStack.top());

        maxStack = new MaxStack();
        maxStack.push(5);
        maxStack.push(1);
        maxStack.push(6);

        System.out.println(maxStack.peekMax());
        System.out.println(maxStack.popMax());
        System.out.println(maxStack.popMax());
        System.out.println(maxStack.top());
    }

    static class MaxStack {

        /** initialize your data structure here. */
        public MaxStack() {
            stack = new LinkedList<>();
            max = new PriorityQueue<>(Comparator.reverseOrder());
        }

        LinkedList<Integer> stack;
        PriorityQueue<Integer> max;

        public void push(int x) {
            stack.add(x);
            max.add(x);
        }

        public int pop() {
            if(stack.isEmpty()) return -1;
            max.remove(stack.peekLast());
            return stack.removeLast();
        }

        public int top() {
            if(stack.isEmpty()) return -1;
            return stack.peekLast();
        }

        public int peekMax() {
            if(max.isEmpty()) return -1;
            return max.peek();
        }

        public int popMax() {
            if(max.isEmpty()) {
                return stack.removeLast();
            }
            
            stack.removeLastOccurrence(max.peek());
            return max.poll();
        }
    }

}
