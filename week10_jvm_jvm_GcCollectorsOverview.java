package jvm;

/**
 * GC Collectors — interview cheat sheet (theory).
 *
 * Serial GC        (-XX:+UseSerialGC)        Single thread, small apps
 * Parallel GC      (-XX:+UseParallelGC)      Throughput focused, multi-core
 * G1 GC            (-XX:+UseG1GC)            Default for many setups, balanced
 * ZGC              (-XX:+UseZGC)             Very low pause, large heaps (Java 15+ prod)
 * Shenandoah       (-XX:+UseShenandoahGC)    Low pause alternative
 *
 * When to tune:
 *   - High GC pause times → consider G1/ZGC, increase heap, fix leaks
 *   - OutOfMemoryError → heap dump, analyze with VisualVM / Eclipse MAT
 *
 * Common errors:
 *   OutOfMemoryError: Java heap space      → too many objects / leak
 *   OutOfMemoryError: Metaspace            → too many classes loaded
 *   StackOverflowError                     → infinite recursion
 */
public class GcCollectorsOverview {

    public static void main(String[] args) {
        System.out.println("===== GC Collectors Overview =====");
        System.out.println("""
                Minor GC  → Young Generation (Eden + Survivor)
                Major GC  → Old Generation
                Full GC   → Entire heap + often metaspace cleanup

                Object lifecycle:
                  new object → Eden
                  survives GC → Survivor
                  survives many cycles → Old Gen

                Tuning flags (examples):
                  -Xms512m -Xmx2g
                  -XX:MaxMetaspaceSize=256m
                  -XX:+HeapDumpOnOutOfMemoryError
                  -XX:HeapDumpPath=./heapdump.hprof
                  -Xlog:gc*:file=gc.log

                Tools:
                  jps, jstat, jmap, jstack, jcmd
                  VisualVM, JConsole, Eclipse MAT
                """);
    }
}
