import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Practice 06 — ThreadLocal isolation (eliminate shared-state bottleneck)
 *
 * SimpleDateFormat is NOT thread-safe. Sharing one instance = corruption + locks.
 * ThreadLocal gives each thread its own formatter — no synchronization needed.
 */
public class P06_ThreadLocalFormatterDemo {

    private static final ThreadLocal<SimpleDateFormat> FORMATTER =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public static String format(Date date) {
        return FORMATTER.get().format(date);
    }

    public static void main(String[] args) throws InterruptedException {
        Date now = new Date();

        Thread t1 = new Thread(() -> System.out.println("T1: " + format(now)), "fmt-1");
        Thread t2 = new Thread(() -> System.out.println("T2: " + format(now)), "fmt-2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Production reminder: remove ThreadLocal in pool threads when done");
        System.out.println("  FORMATTER.remove(); // avoid leaks in reused pool threads");
    }
}
