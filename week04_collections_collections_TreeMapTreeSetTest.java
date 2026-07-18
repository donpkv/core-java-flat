package collections;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * TreeMap / TreeSet: sorted order (natural or Comparator), no duplicates in Set.
 * O(log n) operations.
 */
public class TreeMapTreeSetTest {

    public static void main(String[] args) {
        TreeMap<Integer, String> scores = new TreeMap<>();
        scores.put(85, "Bob");
        scores.put(92, "Alice");
        scores.put(78, "Charlie");

        System.out.println("TreeMap (sorted by key): " + scores);
        System.out.println("First key: " + scores.firstKey());
        System.out.println("Last key: " + scores.lastKey());

        TreeSet<String> names = new TreeSet<>();
        names.add("Zara");
        names.add("Amy");
        names.add("Mike");
        names.add("Amy"); // duplicate ignored

        System.out.println("\nTreeSet (sorted): " + names);

        Set<String> headSet = names.headSet("Mike");
        System.out.println("headSet before Mike: " + headSet);
    }
}
