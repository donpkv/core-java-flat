package jvm;

/**
 * JVM memory areas (conceptual overview):
 *
 * 1. Heap       — objects, arrays (shared by all threads)
 *    - Young Gen: Eden + Survivor (S0, S1) — new objects, Minor GC
 *    - Old Gen     — long-lived objects — Major/Full GC
 *
 * 2. Stack      — per thread: method frames, local primitives, references
 *
 * 3. Metaspace  — class metadata (Java 8+, replaces PermGen)
 *
 * 4. PC Register, Native Method Stack — JVM internals
 *
 * Run this class and read the printed Runtime stats.
 */
public class JvmMemoryOverview {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        long maxMemory = runtime.maxMemory();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;

        System.out.println("===== JVM Memory Overview =====");
        System.out.println("Max heap (-Xmx):     " + toMb(maxMemory) + " MB");
        System.out.println("Total heap (current): " + toMb(totalMemory) + " MB");
        System.out.println("Free heap:            " + toMb(freeMemory) + " MB");
        System.out.println("Used heap:            " + toMb(usedMemory) + " MB");

        System.out.println("\nUseful JVM flags (run from command line):");
        System.out.println("  -Xms512m          Initial heap size");
        System.out.println("  -Xmx1024m         Maximum heap size");
        System.out.println("  -XX:+PrintGCDetails   GC logging (older flag set)");
        System.out.println("  -Xlog:gc*         GC logging (Java 9+ unified logging)");
        System.out.println("  -XX:+HeapDumpOnOutOfMemoryError");

        System.out.println("\nAvailable processors: " + runtime.availableProcessors());
        System.out.println("Java version: " + System.getProperty("java.version"));
        System.out.println("JVM name: " + System.getProperty("java.vm.name"));
    }

    static double toMb(long bytes) {
        return bytes / (1024.0 * 1024.0);
    }
}
