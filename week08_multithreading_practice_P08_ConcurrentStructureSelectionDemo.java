import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Practice 08 — When to pick which concurrent structure (selection matrix demo)
 *
 * See QUESTIONS.txt for full matrix. This program labels each choice.
 */
public class P08_ConcurrentStructureSelectionDemo {

    // High reads, moderate writes — shared cache / session store
    private final ConcurrentHashMap<String, String> sessionCache = new ConcurrentHashMap<>();

    // Ultra-high reads, rare writes — listener lists, config snapshots
    private final CopyOnWriteArrayList<String> eventListeners = new CopyOnWriteArrayList<>();

    // High throughput, non-blocking queue — message fan-out
    private final ConcurrentLinkedQueue<String> eventStream = new ConcurrentLinkedQueue<>();

    // Producer-consumer with memory bounds — thread pool / work queue
    private final BlockingQueue<String> boundedWorkQueue = new ArrayBlockingQueue<>(500);

    public static void main(String[] args) throws InterruptedException {
        P08_ConcurrentStructureSelectionDemo demo = new P08_ConcurrentStructureSelectionDemo();

        demo.sessionCache.put("sid:1", "Alice");
        System.out.println("ConcurrentHashMap read: " + demo.sessionCache.get("sid:1"));

        demo.eventListeners.add("AuditListener");
        for (String l : demo.eventListeners) {
            System.out.println("CopyOnWrite iterate (no lock): " + l);
        }

        demo.eventStream.offer("order-created");
        System.out.println("ConcurrentLinkedQueue poll: " + demo.eventStream.poll());

        demo.boundedWorkQueue.put("job-1");
        System.out.println("ArrayBlockingQueue take: " + demo.boundedWorkQueue.take());

        System.out.println("\nAvoid: Hashtable, Vector, Collections.synchronizedMap() under load");
    }
}
