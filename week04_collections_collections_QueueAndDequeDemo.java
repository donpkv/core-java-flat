package collections;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Queue (FIFO) and Deque (double-ended queue).
 * ArrayDeque is usually faster than LinkedList for queue/stack use cases.
 */
public class QueueAndDequeDemo {

    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println("Stack pop order: " + stack.pop() + ", " + stack.pop());

        Deque<String> queue = new ArrayDeque<>();
        queue.offerLast("one");
        queue.offerLast("two");
        queue.offerLast("three");
        System.out.println("Queue poll order: " + queue.pollFirst() + ", " + queue.pollFirst());
    }
}
