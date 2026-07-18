package functionalinterface;

// A simple program to demonstrate the use
// of predicate interface

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Function;
class PredeicateTest {
    public static void main(String args[])
    {

        // create a list of strings
        List<String> names = Arrays.asList(
                "Geek", "GeeksQuiz", "g1", "QA", "Geek2");

        // declare the predicate type as string and use
        // lambda expression to create object
        Predicate<String> p = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("G");
            }
        };

        // Iterate through the list
        for (String st : names) {
            // call the test method
            if (p.test(st))
                System.out.println(st);
        }

      /*Function function= PredeicateTest::apply;
        function.apply(names);*/

    }

   /* private static Object apply(Object o) {
        return null;
    }*/
}
