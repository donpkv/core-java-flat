package collections;

import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList: doubly-linked list, good for frequent insert/remove at ends.
 * ArrayList: better for random access by index.
 */
public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<String> queueLike = new LinkedList<>();

        queueLike.addLast("first");
        queueLike.addLast("second");
        queueLike.addFirst("zero");

        System.out.println("LinkedList: " + queueLike);
        System.out.println("removeFirst: " + queueLike.removeFirst());
        System.out.println("after poll: " + queueLike);

        List<String> asList = new LinkedList<>();
        asList.add("A");
        asList.add("B");
        asList.add(1, "X"); // insert in middle — LinkedList strength
        System.out.println("insert middle: " + asList);
    }
}
