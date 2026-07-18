/**
 * Practice 05 — Production memory leak triage checklist (print + follow)
 *
 * Pair with PRODUCTION_RUNBOOK.txt for commands.
 */
public class P05_ProductionMemoryLeakTriageChecklist {

    public static void main(String[] args) {
        System.out.println("""
                ===== MEMORY LEAK TRIAGE (PRODUCTION) =====

                1. CONFIRM IN METRICS (before code)
                   - Sawtooth (healthy) vs staircase (leak)
                   - Full GC after Full GC: used heap baseline keeps rising
                   - Alert: heap > 80%, GC time > 5% of wall clock

                2. ENABLE / CHECK GC LOGS
                   -Xlog:gc*,gc+age=trace:file=gc.log:time,uptime:filecount=5,filesize=100M

                3. CAPTURE HEAP DATA (low overhead first)
                   jcmd <PID> GC.class_histogram   # top objects by count
                   jmap -histo:live <PID>          # histogram after full GC
                   jcmd <PID> GC.heap_dump dump.hprof   # full dump when needed

                4. AUTOMATE ON CRASH
                   -XX:+HeapDumpOnOutOfMemoryError
                   -XX:HeapDumpPath=/var/log/app/heap.hprof

                5. ANALYZE OFFLINE (never on prod node under load)
                   Eclipse MAT → Leak Suspects Report
                   VisualVM → heap dump → Dominator tree
                   Look for: static collections, unbounded caches, ThreadLocal leaks

                6. CONTINUOUS PROFILING (<1% overhead)
                   jcmd <PID> JFR.start duration=10m filename=leak.jfr settings=profile
                   Open in JDK Mission Control → Live Objects / Allocation

                7. FIX PATTERNS
                   - Bound cache size + eviction (LRU/TTL)
                   - Remove from static maps when done
                   - WeakReference for optional cache entries
                   - ThreadLocal.remove() in thread pools

                Practice code: P01_StaticCacheMemoryLeakDemo
                """);
    }
}
