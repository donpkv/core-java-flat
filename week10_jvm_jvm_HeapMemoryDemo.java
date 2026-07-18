package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates heap usage growing when objects are created.
 * Objects that are unreachable become eligible for Garbage Collection.
 *
 * Try running with:
 *   java -Xms64m -Xmx128m jvm.HeapMemoryDemo
 */
public class HeapMemoryDemo {

    public static void main(String[] args) throws InterruptedException {
        Runtime rt = Runtime.getRuntime();
        printMemory("Start", rt);

        List<byte[]> holders = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            holders.add(new byte[1024 * 1024]); // 1 MB each
            printMemory("After allocating " + i + " MB", rt);
        }

        System.out.println("\nClearing references — objects now eligible for GC");
        holders.clear();
        holders = null;

        System.gc(); // hint only — JVM decides when to actually collect
        Thread.sleep(500);
        printMemory("After GC hint", rt);
    }

    static void printMemory(String label, Runtime rt) {
        long used = rt.totalMemory() - rt.freeMemory();
        System.out.printf("%s -> used: %.2f MB%n", label, used / (1024.0 * 1024.0));
    }
}
