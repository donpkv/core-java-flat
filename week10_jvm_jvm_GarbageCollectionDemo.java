package jvm;

/**
 * Garbage Collection basics:
 *
 * - GC reclaims memory of objects with NO live references
 * - Minor GC: cleans Young Generation (Eden/Survivor) — frequent, fast
 * - Major/Full GC: cleans Old Generation — less frequent, can pause app
 *
 * Common collectors (Java 21 default often G1GC):
 *   Serial, Parallel, G1, ZGC, Shenandoah
 *
 * System.gc() is only a SUGGESTION — do not rely on it in production.
 */
public class GarbageCollectionDemo {

    public static void main(String[] args) throws InterruptedException {
        Runtime rt = Runtime.getRuntime();
        printUsed("Before creating garbage", rt);

        for (int round = 0; round < 3; round++) {
            createAndDropObjects();
            System.gc();
            Thread.sleep(300);
            printUsed("After round " + (round + 1) + " + GC hint", rt);
        }

        System.out.println("\nKey interview points:");
        System.out.println("1. GC roots: stack refs, static fields, JNI refs");
        System.out.println("2. Unreachable object → eligible for GC (not immediately deleted)");
        System.out.println("3. finalize() deprecated — use try-with-resources / cleaners");
    }

    static void createAndDropObjects() {
        for (int i = 0; i < 100_000; i++) {
            String temp = "temp-" + i; // short-lived objects in young gen
        }
    }

    static void printUsed(String label, Runtime rt) {
        long used = rt.totalMemory() - rt.freeMemory();
        System.out.printf("%s -> used: %.2f MB%n", label, used / (1024.0 * 1024.0));
    }
}
