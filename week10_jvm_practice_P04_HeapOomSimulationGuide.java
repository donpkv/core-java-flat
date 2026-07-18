import java.util.ArrayList;
import java.util.List;

/**
 * Practice 04 — Heap OOM simulation guide
 *
 * Run with small heap to trigger OOM quickly:
 *   java -Xms16m -Xmx32m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./heap_oom.hprof P04_HeapOomSimulationGuide
 *
 * Production: always set HeapDumpOnOutOfMemoryError on startup script.
 */
public class P04_HeapOomSimulationGuide {

    public static void main(String[] args) {
        System.out.println("Allocating until OutOfMemoryError: Java heap space");
        List<byte[]> list = new ArrayList<>();
        try {
            while (true) {
                list.add(new byte[1024 * 1024]); // 1 MB
            }
        } catch (OutOfMemoryError oom) {
            System.out.println("OOM caught: " + oom.getMessage());
            System.out.println("If flags set, check heap_oom.hprof → open in Eclipse MAT");
        }
    }
}
