import java.util.ArrayList;
import java.util.List;

/**
 * Practice 01 — Memory leak pattern (static cache never cleared)
 *
 * PRODUCTION SYMPTOM: heap baseline rises in staircase after each Full GC → OOM.
 * HEALTHY: sawtooth — GC drops back to stable baseline.
 *
 * FIX: bounded cache, TTL, WeakReference, or remove entries when done.
 */
public class P01_StaticCacheMemoryLeakDemo {

    private static final List<byte[]> LEAK_CACHE = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Simulating leak: objects kept in static list forever");
        for (int i = 0; i < 5000; i++) {
            LEAK_CACHE.add(new byte[2048]);
        }
        System.out.println("Cached objects: " + LEAK_CACHE.size());
        System.out.println("Run with: java -Xms32m -Xmx64m P01_StaticCacheMemoryLeakDemo");
        System.out.println("Watch used heap via JMX / APM — baseline never drops after GC");
    }
}
