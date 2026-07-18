package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Built-in: @Override, @Deprecated, @FunctionalInterface, @SuppressWarnings
 * Custom annotations: metadata for code, frameworks (Spring, JUnit).
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface TestMarker {
    String value() default "";
}

public class AnnotationsDemo {

    @Override
    public String toString() {
        return "AnnotationsDemo";
    }

    @Deprecated
    void oldMethod() {
        System.out.println("deprecated");
    }

    @TestMarker("sample test")
    void sampleTest() {
        System.out.println("Running sample test");
    }

    public static void main(String[] args) throws Exception {
        AnnotationsDemo demo = new AnnotationsDemo();
        System.out.println(demo);

        var method = AnnotationsDemo.class.getMethod("sampleTest");
        if (method.isAnnotationPresent(TestMarker.class)) {
            TestMarker marker = method.getAnnotation(TestMarker.class);
            System.out.println("TestMarker value: " + marker.value());
        }
    }
}
