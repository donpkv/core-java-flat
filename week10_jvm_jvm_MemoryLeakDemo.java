package jvm;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * MEMORY LEAK: object still referenced → GC cannot collect → heap grows.
 *
 * Anti-pattern: static collection holding objects forever.
 * FIX: remove from collection, use WeakReference, or limit cache size.
 */
public class MemoryLeakDemo {

    // static list keeps references alive for entire app lifetime
    private static final List<Object> CACHE = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Adding 10000 objects to static CACHE (simulated leak)");
        for (int i = 0; i < 10_000; i++) {
            CACHE.add(new byte[1024]); // 1 KB each — references never released
        }
        System.out.println("CACHE size: " + CACHE.size());
        System.out.println("These objects stay until CACHE is cleared or app exits");

        System.out.println("\nWeakReference demo — object can be GC'd:");
        Object heavy = new byte[1024 * 1024];
        WeakReference<Object> weakRef = new WeakReference<>(heavy);
        heavy = null; // remove strong reference

        System.gc();
        System.out.println("Weak ref still alive? " + (weakRef.get() != null));
    }
}
