package streams;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Common Collectors used with stream.collect(...)
 *
 * Run from core_java_programs module root.
 */
public class StreamCollectorsExample {

    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Alex", "Brian", "Charlie");
        List<Integer> scores = List.of(90, 45, 78, 78, 92, 55);

        System.out.println("--- toList / toSet / toCollection ---");
        System.out.println("toList      : " + toList(names));
        System.out.println("toSet       : " + toSet(names));
        System.out.println("toCollection: " + toLinkedHashSet(names));

        System.out.println("\n--- toMap ---");
        System.out.println("name -> length : " + nameToLengthMap(names));
        System.out.println("first letter -> names : " + firstLetterToNamesMap(names));

        System.out.println("\n--- counting / summing / averaging / summarizing ---");
        System.out.println("count names   : " + count(names));
        System.out.println("sum scores    : " + sumScores(scores));
        System.out.println("avg scores    : " + avgScores(scores));
        System.out.println("stats scores  : " + scoreStats(scores));

        System.out.println("\n--- minBy / maxBy ---");
        System.out.println("longest name  : " + longestName(names));
        System.out.println("highest score : " + highestScore(scores));

        System.out.println("\n--- joining ---");
        System.out.println("join comma    : " + joinComma(names));
        System.out.println("join formatted: " + joinFormatted(names));

        System.out.println("\n--- groupingBy + downstream ---");
        System.out.println("group count   : " + countByFirstLetter(names));
        System.out.println("group join    : " + joinNamesByFirstLetter(names));
        System.out.println("group max len : " + maxLengthByFirstLetter(names));

        System.out.println("\n--- partitioningBy ---");
        System.out.println("partition     : " + partitionByLength(names));

        System.out.println("\n--- collectingAndThen ---");
        System.out.println("unmodifiable  : " + unmodifiableLongNames(names));

        System.out.println("\n--- filter + collect ---");
        System.out.println("filtered list : " + longNames(names));
    }

    static List<String> toList(List<String> names) {
        return names.stream().collect(Collectors.toList());
    }

    static Set<String> toSet(List<String> names) {
        return names.stream().collect(Collectors.toSet());
    }

    static LinkedHashSet<String> toLinkedHashSet(List<String> names) {
        return names.stream().collect(Collectors.toCollection(LinkedHashSet::new));
    }

    static Map<String, Integer> nameToLengthMap(List<String> names) {
        return names.stream()
                .collect(Collectors.toMap(name -> name, String::length));
    }

    static Map<String, String> firstLetterToNamesMap(List<String> names) {
        return names.stream()
                .collect(Collectors.toMap(
                        name -> String.valueOf(name.charAt(0)),
                        name -> name,
                        (existing, incoming) -> existing + ", " + incoming
                ));
    }

    static long count(List<String> names) {
        return names.stream().collect(Collectors.counting());
    }

    static int sumScores(List<Integer> scores) {
        return scores.stream().collect(Collectors.summingInt(i -> i));
    }

    static double avgScores(List<Integer> scores) {
        return scores.stream().collect(Collectors.averagingInt(i -> i));
    }

    static IntSummaryStatistics scoreStats(List<Integer> scores) {
        return scores.stream().collect(Collectors.summarizingInt(i -> i));
    }

    static String longestName(List<String> names) {
        return names.stream()
                .collect(Collectors.maxBy(Comparator.comparingInt(String::length)))
                .orElse("");
    }

    static Integer highestScore(List<Integer> scores) {
        return scores.stream()
                .collect(Collectors.maxBy(Integer::compareTo))
                .orElse(0);
    }

    static String joinComma(List<String> names) {
        return names.stream().collect(Collectors.joining(", "));
    }

    static String joinFormatted(List<String> names) {
        return names.stream()
                .collect(Collectors.joining(" | ", "[", "]"));
    }

    static Map<String, Long> countByFirstLetter(List<String> names) {
        return names.stream()
                .collect(Collectors.groupingBy(
                        name -> String.valueOf(name.charAt(0)),
                        Collectors.counting()
                ));
    }

    static Map<String, String> joinNamesByFirstLetter(List<String> names) {
        return names.stream()
                .collect(Collectors.groupingBy(
                        name -> String.valueOf(name.charAt(0)),
                        Collectors.mapping(name -> name, Collectors.joining(", "))
                ));
    }

    static Map<String, Integer> maxLengthByFirstLetter(List<String> names) {
        return names.stream()
                .collect(Collectors.groupingBy(
                        name -> String.valueOf(name.charAt(0)),
                        Collectors.mapping(String::length, Collectors.maxBy(Integer::compareTo))
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().orElse(0)
                ));
    }

    static Map<Boolean, List<String>> partitionByLength(List<String> names) {
        return names.stream()
                .collect(Collectors.partitioningBy(name -> name.length() <= 4));
    }

    static List<String> unmodifiableLongNames(List<String> names) {
        return names.stream()
                .filter(name -> name.length() > 4)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        List::copyOf
                ));
    }

    static List<String> longNames(List<String> names) {
        return names.stream()
                .filter(name -> name.length() > 4)
                .collect(Collectors.toList());
    }
}
