package collections;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap: thread-safe Map without locking entire map.
 * Better than Hashtable; allows concurrent reads and segmented writes.
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) throws InterruptedException {
        Map<Integer, Integer> map = new ConcurrentHashMap<>();

        Runnable increment = () -> {
            for (int i = 0; i < 1000; i++) {
                map.merge(1, 1, Integer::sum);
            }
        };

        Thread t1 = new Thread(increment);
        Thread t2 = new Thread(increment);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Expected 2000, actual: " + map.get(1));

        // putIfAbsent — only put if key missing
        map.putIfAbsent(2, 100);
        map.putIfAbsent(2, 999);
        System.out.println("putIfAbsent result: " + map.get(2));
    }
}
