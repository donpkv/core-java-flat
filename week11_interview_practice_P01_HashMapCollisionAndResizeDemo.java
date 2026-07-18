import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Practice 01 — HashMap collision + resize (IBM interview topic)
 *
 * Java 8+: bucket > 8 nodes → tree (Red-Black). Load factor 0.75 → double capacity rehash.
 */
public class P01_HashMapCollisionAndResizeDemo {

    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<>(); // ordered for demo visibility

        // Keys with same hash bucket possible — HashMap handles via linked list / tree
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        System.out.println("Size: " + map.size());
        System.out.println("Get 2: " + map.get(2));

        System.out.println("""
                
                Interview answer summary:
                - Array of buckets; hash(key) % capacity → bucket index
                - Collision: linked list in bucket (tree if bucket > 8)
                - Resize when size > capacity * 0.75 → double array, rehash all entries
                """);
    }
}
