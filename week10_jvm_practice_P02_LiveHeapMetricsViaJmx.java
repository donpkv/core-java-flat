import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

/**
 * Practice 02 — Live heap metrics (same data APM/JMX uses)
 *
 * Production: Grafana/Datadog charts come from MemoryMXBean + GC beans.
 */
public class P02_LiveHeapMetricsViaJmx {

    public static void main(String[] args) throws InterruptedException {
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();

        for (int i = 0; i < 3; i++) {
            MemoryUsage heap = memoryBean.getHeapMemoryUsage();
            MemoryUsage nonHeap = memoryBean.getNonHeapMemoryUsage();

            System.out.println("--- sample " + (i + 1) + " ---");
            printUsage("Heap", heap);
            printUsage("Non-Heap (Metaspace, code cache)", nonHeap);

            byte[] temp = new byte[1024 * 1024];
            System.out.println("Allocated 1MB array: " + temp.length);
            Thread.sleep(500);
        }
    }

    static void printUsage(String label, MemoryUsage usage) {
        System.out.printf("%s: used=%d MB, committed=%d MB, max=%d MB%n",
                label,
                usage.getUsed() / (1024 * 1024),
                usage.getCommitted() / (1024 * 1024),
                usage.getMax() / (1024 * 1024));
    }
}
