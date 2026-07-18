import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Practice 03 — LRU cache eviction (Redis interview topic)
 *
 * LinkedHashMap accessOrder=true evicts eldest when size > max.
 * Redis LRU: evict least recently used when memory full.
 */
public class P03_LruCacheEvictionDemo {

    static class LruCache<K, V> extends LinkedHashMap<K, V> {
        private final int maxSize;

        LruCache(int maxSize) {
            super(maxSize, 0.75f, true); // accessOrder = true for LRU
            this.maxSize = maxSize;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > maxSize;
        }
    }

    public static void main(String[] args) {
        LruCache<String, String> cache = new LruCache<>(3);
        cache.put("a", "1");
        cache.put("b", "2");
        cache.put("c", "3");
        cache.get("a");           // touch a → b becomes LRU candidate
        cache.put("d", "4");      // evicts b

        System.out.println("Cache: " + cache);
        System.out.println("Expected: b evicted → {a=1, c=3, d=4}");
    }
}
