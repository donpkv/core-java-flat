package jvm;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.RuntimeMXBean;

/**
 * JVM Management API (java.lang.management):
 * Used by monitoring tools — JVisualVM, JConsole, Micrometer, Prometheus agents.
 *
 * Interview: know MemoryMXBean and GarbageCollectorMXBean exist for monitoring.
 */
public class JvmManagementDemo {

    public static void main(String[] args) {
        RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();

        System.out.println("===== JVM Management API =====");
        System.out.println("JVM uptime (ms): " + runtimeBean.getUptime());
        System.out.println("JVM name: " + runtimeBean.getVmName());
        System.out.println("Input args: " + runtimeBean.getInputArguments());

        MemoryUsage heap = memoryBean.getHeapMemoryUsage();
        MemoryUsage nonHeap = memoryBean.getNonHeapMemoryUsage();

        printUsage("Heap", heap);
        printUsage("Non-Heap (Metaspace, code cache, etc.)", nonHeap);

        System.out.println("\nGarbage Collectors:");
        for (GarbageCollectorMXBean gc : ManagementFactory.getGarbageCollectorMXBeans()) {
            System.out.printf("  %s -> collections=%d, time=%d ms%n",
                    gc.getName(), gc.getCollectionCount(), gc.getCollectionTime());
        }
    }

    static void printUsage(String label, MemoryUsage usage) {
        System.out.printf("%s: init=%d KB, used=%d KB, committed=%d KB, max=%d KB%n",
                label,
                usage.getInit() / 1024,
                usage.getUsed() / 1024,
                usage.getCommitted() / 1024,
                usage.getMax() / 1024);
    }
}
