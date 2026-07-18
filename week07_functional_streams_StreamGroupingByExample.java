package streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Collectors.groupingBy — group stream elements into a Map by a key.
 *
 * Key mapper function: element -> key
 * Result: Map<Key, List<Element>>
 */
public class StreamGroupingByExample {

    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Alex", "Brian", "Charlie");

        System.out.println("By first letter : " + groupByFirstLetter(names));
        System.out.println("By length       : " + groupByLength(names));
        System.out.println("By last letter  : " + groupByLastLetter(names));
        System.out.println("Count per letter: " + countByFirstLetter(names));
        System.out.println("Short vs long   : " + partitionByLength(names));
    }

    /** name -> first character as String key */
    static Map<String, List<String>> groupByFirstLetter(List<String> names) {
        return names.stream()
                .collect(Collectors.groupingBy(
                        name -> String.valueOf(name.charAt(0))
                ));
        // {A=[Alice, Alex], B=[Bob, Brian], C=[Charlie]}
    }

    /** name -> length of name (Integer key) */
    static Map<Integer, List<String>> groupByLength(List<String> names) {
        return names.stream()
                .collect(Collectors.groupingBy(String::length));
        // {3=[Bob], 4=[Alex], 5=[Alice, Brian], 7=[Charlie]}
    }

    /** name -> last character as String key */
    static Map<String, List<String>> groupByLastLetter(List<String> names) {
        return names.stream()
                .collect(Collectors.groupingBy(
                        name -> String.valueOf(name.charAt(name.length() - 1))
                ));
        // {e=[Alice, Charlie], b=[Bob], x=[Alex], n=[Brian]}
    }

    /** first letter -> how many names start with that letter */
    static Map<String, Long> countByFirstLetter(List<String> names) {
        return names.stream()
                .collect(Collectors.groupingBy(
                        name -> String.valueOf(name.charAt(0)),
                        Collectors.counting()
                ));
        // {A=2, B=2, C=1}
    }

    /** partition: true = length <= 4, false = length > 4 */
    static Map<Boolean, List<String>> partitionByLength(List<String> names) {
        return names.stream()
                .collect(Collectors.partitioningBy(name -> name.length() <= 4));
        // {true=[Bob, Alex], false=[Alice, Brian, Charlie]}
    }
}
