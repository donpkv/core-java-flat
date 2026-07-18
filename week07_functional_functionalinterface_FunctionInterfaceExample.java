package functionalinterface;

import java.util.function.Function;

/**
 * Function<T, R>: takes T, returns R.
 * map in streams uses Function.
 */
public class FunctionInterfaceExample {

    public static void main(String[] args) {
        Function<String, Integer> lengthFn = String::length;
        Function<Integer, Integer> squareFn = x -> x * x;

        Function<String, Integer> combined = lengthFn.andThen(squareFn);

        System.out.println("length of Java squared: " + combined.apply("Java"));

        Function<String, String> identity = Function.identity();
        System.out.println("identity: " + identity.apply("test"));
    }
}
