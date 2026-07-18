import java.util.concurrent.ConcurrentHashMap;

/**
 * Practice 05 — Thread-safe cache with ConcurrentHashMap.computeIfAbsent
 *
 * WRONG: if (!map.containsKey(k)) map.put(k, load(k))  — race between threads
 * RIGHT: map.computeIfAbsent(k, this::load)             — atomic, runs loader once
 */
public class P05_ConcurrentHashMapComputeIfAbsent {

    private final ConcurrentHashMap<String, UserProfile> cache = new ConcurrentHashMap<>();

    public UserProfile getUserProfile(String userId) {
        return cache.computeIfAbsent(userId, this::fetchFromDatabase);
    }

    private UserProfile fetchFromDatabase(String id) {
        System.out.println("DB fetch for " + id + " on thread " + Thread.currentThread().getName());
        sleepQuiet(100);
        return new UserProfile(id);
    }

    public static void main(String[] args) throws InterruptedException {
        P05_ConcurrentHashMapComputeIfAbsent manager = new P05_ConcurrentHashMapComputeIfAbsent();

        Runnable task = () -> {
            UserProfile p = manager.getUserProfile("user-42");
            System.out.println("Got profile: " + p.id);
        };

        Thread t1 = new Thread(task, "req-1");
        Thread t2 = new Thread(task, "req-2");
        Thread t3 = new Thread(task, "req-3");
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        // Expect only ONE "DB fetch" line for same userId
    }

    static void sleepQuiet(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    static class UserProfile {
        final String id;
        UserProfile(String id) { this.id = id; }
    }
}
