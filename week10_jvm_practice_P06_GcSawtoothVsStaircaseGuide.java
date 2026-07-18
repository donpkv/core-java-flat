/**
 * Practice 06 — Sawtooth vs staircase (concept guide)
 *
 * Open Grafana heap chart while reading this.
 */
public class P06_GcSawtoothVsStaircaseGuide {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("""
                HEALTHY (sawtooth):
                  used heap ↑ allocate → GC runs → drops to stable baseline → repeat

                LEAK (staircase):
                  used heap ↑ → Full GC → drops a little but NEW baseline higher
                  repeat until OutOfMemoryError: Java heap space

                METASPACE LEAK:
                  OutOfMemoryError: Metaspace — too many classes (dynamic proxies, Groovy, etc.)

                STACK (not heap):
                  StackOverflowError — recursion; fix logic not -Xmx
                """);

        // mini sawtooth: allocate temp, allow GC
        for (int round = 0; round < 3; round++) {
            byte[] temp = new byte[2 * 1024 * 1024];
            System.out.println("Round " + round + " allocated " + temp.length + " bytes");
            temp = null;
            System.gc(); // suggestion only — in prod GC runs on its own schedule
            Thread.sleep(200);
            long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            System.out.println("Approx used heap MB: " + used / (1024 * 1024));
        }
    }
}
