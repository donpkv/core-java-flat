package jvm;

/**
 * Metaspace stores class metadata (class names, methods, constant pool refs).
 * Java 8+ replaced PermGen with Metaspace (native memory, grows dynamically).
 *
 * ClassLoader loads .class → metadata goes to Metaspace.
 * Leak scenario: redeploy apps in same JVM without unloading ClassLoaders.
 */
public class MetaspaceDemo {

    public static void main(String[] args) {
        System.out.println("===== Metaspace =====");
        System.out.println("PermGen (Java 7 and earlier) → Metaspace (Java 8+)");
        System.out.println("Stores: class metadata, static class info");
        System.out.println("Does NOT store: String pool (moved to heap in Java 7), object instances");
        System.out.println("\nLoaded classes count grows as more classes are loaded:");
        System.out.println("Approx classes loaded: " + getLoadedClassCount());

        // loading another class increases metaspace usage slightly
        loadExtraClass();
        System.out.println("After loading extra class: " + getLoadedClassCount());
    }

    static int getLoadedClassCount() {
        return ManagementFactoryHelper.getLoadedClassCount();
    }

    static void loadExtraClass() {
        try {
            Class.forName("jvm.GcCollectorsOverview");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load class: " + e.getMessage());
        }
    }
}

/** tiny helper to avoid importing ManagementFactory in demo flow */
class ManagementFactoryHelper {
    static int getLoadedClassCount() {
        return java.lang.management.ManagementFactory.getClassLoadingMXBean().getLoadedClassCount();
    }
}
