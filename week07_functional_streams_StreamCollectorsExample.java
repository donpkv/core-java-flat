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
 * Input data used throughout:
 *   names  = ["Alice", "Bob", "Alex", "Brian", "Charlie"]
 *   scores = [90, 45, 78, 78, 92, 55]
 *
 * Run from core_java_programs module root.
 */
public class StreamCollectorsExample {

    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Alex", "Brian", "Charlie");
        List<Integer> scores = List.of(90, 45, 78, 78, 92, 55);

        System.out.println("--- toList / toSet / toCollection ---");
        System.out.println("toList      : " + toList(names));
        // toList      : [Alice, Bob, Alex, Brian, Charlie]

        System.out.println("toSet       : " + toSet(names));
        // toSet       : [Bob, Alice, Charlie, Alex, Brian]  ← no guaranteed order

        System.out.println("toCollection: " + toLinkedHashSet(names));
        // toCollection: [Alice, Bob, Alex, Brian, Charlie]  ← insertion order preserved

        System.out.println("\n--- toMap ---");
        System.out.println("name -> length : " + nameToLengthMap(names));
        // name -> length : {Bob=3, Alice=5, Charlie=7, Alex=4, Brian=5}

        System.out.println("first letter -> names : " + firstLetterToNamesMap(names));
        // first letter -> names : {A=Alice, Alex, B=Bob, Brian, C=Charlie}

        System.out.println("\n--- counting / summing / averaging / summarizing ---");
        System.out.println("count names   : " + count(names));
        // count names   : 5

        System.out.println("sum scores    : " + sumScores(scores));
        // sum scores    : 438

        System.out.println("avg scores    : " + avgScores(scores));
        // avg scores    : 73.0

        System.out.println("stats scores  : " + scoreStats(scores));
        // stats scores  : IntSummaryStatistics{count=6, sum=438, min=45, average=73.0, max=92}

        System.out.println("\n--- minBy / maxBy ---");
        System.out.println("longest name  : " + longestName(names));
        // longest name  : Charlie

        System.out.println("highest score : " + highestScore(scores));
        // highest score : 92

        System.out.println("\n--- joining ---");
        System.out.println("join comma    : " + joinComma(names));
        // join comma    : Alice, Bob, Alex, Brian, Charlie

        System.out.println("join formatted: " + joinFormatted(names));
        // join formatted: [Alice | Bob | Alex | Brian | Charlie]

        System.out.println("\n--- groupingBy + downstream ---");
        System.out.println("group count   : " + countByFirstLetter(names));
        // group count   : {A=2, B=2, C=1}

        System.out.println("group join    : " + joinNamesByFirstLetter(names));
        // group join    : {A=Alice, Alex, B=Bob, Brian, C=Charlie}

        System.out.println("group max len : " + maxLengthByFirstLetter(names));
        // group max len : {A=5, B=5, C=7}

        System.out.println("\n--- partitioningBy ---");
        System.out.println("partition     : " + partitionByLength(names));
        // partition     : {false=[Alice, Brian, Charlie], true=[Bob, Alex]}

        System.out.println("\n--- collectingAndThen ---");
        System.out.println("unmodifiable  : " + unmodifiableLongNames(names));
        // unmodifiable  : [Alice, Brian, Charlie]

        System.out.println("\n--- filter + collect ---");
        System.out.println("filtered list : " + longNames(names));
        // filtered list : [Alice, Brian, Charlie]
    }

    /**
     * WHAT: Collects all stream elements into an ordered List.
     * HOW:  Collectors.toList() accumulates each element in encounter order.
     *       Modern alternative: .toList() (Java 16+, returns unmodifiable list).
     * OUTPUT: [Alice, Bob, Alex, Brian, Charlie]
     */
    static List<String> toList(List<String> names) {
        return names.stream().collect(Collectors.toList());
    }

    /**
     * WHAT: Collects stream elements into a Set — duplicates removed, no order guarantee.
     * HOW:  Collectors.toSet() uses a HashSet internally.
     *       If two elements are equal (equals/hashCode), only one is kept.
     * OUTPUT: [Bob, Alice, Charlie, Alex, Brian]  ← order varies each run
     */
    static Set<String> toSet(List<String> names) {
        return names.stream().collect(Collectors.toSet());
    }

    /**
     * WHAT: Collects into a specific collection type — here, LinkedHashSet.
     * HOW:  Collectors.toCollection(supplier) calls the supplier to create the
     *       target collection, then adds each element.
     *       LinkedHashSet = HashSet + insertion order preserved.
     * OUTPUT: [Alice, Bob, Alex, Brian, Charlie]  ← insertion order kept, no duplicates
     */
    static LinkedHashSet<String> toLinkedHashSet(List<String> names) {
        return names.stream().collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /**
     * WHAT: Converts each element into a Map entry: name → its length.
     * HOW:  Collectors.toMap(keyMapper, valueMapper)
     *         keyMapper   = name -> name       (identity, name becomes key)
     *         valueMapper = String::length     (length becomes value)
     *       Throws IllegalStateException if duplicate keys exist.
     * OUTPUT: {Bob=3, Alice=5, Charlie=7, Alex=4, Brian=5}
     */
    static Map<String, Integer> nameToLengthMap(List<String> names) {
        return names.stream()
                .collect(Collectors.toMap(name -> name, String::length));
    }

    /**
     * WHAT: Groups names by their first letter into a Map<firstLetter, combinedNames>.
     * HOW:  Collectors.toMap with a merge function (3rd argument).
     *         keyMapper   = first character of name
     *         valueMapper = the name itself
     *         mergeFunction = (existing, incoming) -> existing + ", " + incoming
     *       Merge function is called only when two elements produce the SAME key.
     *       Without it, duplicate keys throw IllegalStateException.
     * OUTPUT: {A=Alice, Alex, B=Bob, Brian, C=Charlie}
     *         "A" collides (Alice + Alex) → merge joins them with ", "
     */
    static Map<String, String> firstLetterToNamesMap(List<String> names) {
        return names.stream()
                .collect(Collectors.toMap(
                        name -> String.valueOf(name.charAt(0)),  // key
                        name -> name,                            // value
                        (existing, incoming) -> existing + ", " + incoming  // merge on collision
                ));
    }

    /**
     * WHAT: Counts total number of elements in the stream.
     * HOW:  Collectors.counting() is equivalent to stream.count()
     *       but useful as a downstream collector inside groupingBy.
     * OUTPUT: 5
     */
    static long count(List<String> names) {
        return names.stream().collect(Collectors.counting());
    }

    /**
     * WHAT: Sums all integer values in the stream.
     * HOW:  Collectors.summingInt(mapper) applies the mapper to each element
     *       and accumulates the total.
     *       Here mapper = i -> i (identity, score is already an int).
     *       90+45+78+78+92+55 = 438
     * OUTPUT: 438
     */
    static int sumScores(List<Integer> scores) {
        return scores.stream().collect(Collectors.summingInt(i -> i));
    }

    /**
     * WHAT: Calculates average of all integer values.
     * HOW:  Collectors.averagingInt(mapper) sums all values then divides by count.
     *       Returns double always (even if result is whole number).
     *       438 / 6 = 73.0
     * OUTPUT: 73.0
     */
    static double avgScores(List<Integer> scores) {
        return scores.stream().collect(Collectors.averagingInt(i -> i));
    }

    /**
     * WHAT: Computes count, sum, min, max, and average in a single pass.
     * HOW:  Collectors.summarizingInt returns an IntSummaryStatistics object
     *       holding all 5 stats simultaneously — more efficient than running
     *       5 separate streams.
     * OUTPUT: IntSummaryStatistics{count=6, sum=438, min=45, average=73.000000, max=92}
     */
    static IntSummaryStatistics scoreStats(List<Integer> scores) {
        return scores.stream().collect(Collectors.summarizingInt(i -> i));
    }

    /**
     * WHAT: Finds the name with the maximum length.
     * HOW:  Collectors.maxBy(comparator) uses the comparator to find the largest element.
     *       Comparator.comparingInt(String::length) compares names by their length.
     *       Returns Optional<String> — orElse("") handles empty stream.
     *       Charlie has length 7 — the longest.
     * OUTPUT: "Charlie"
     */
    static String longestName(List<String> names) {
        return names.stream()
                .collect(Collectors.maxBy(Comparator.comparingInt(String::length)))
                .orElse("");
    }

    /**
     * WHAT: Finds the highest score in the list.
     * HOW:  Collectors.maxBy(Integer::compareTo) compares integers naturally.
     *       Returns Optional<Integer> — orElse(0) handles empty stream.
     * OUTPUT: 92
     */
    static Integer highestScore(List<Integer> scores) {
        return scores.stream()
                .collect(Collectors.maxBy(Integer::compareTo))
                .orElse(0);
    }

    /**
     * WHAT: Joins all names into a single String separated by ", ".
     * HOW:  Collectors.joining(delimiter) concatenates stream elements
     *       (must be a stream of String) with the given separator between each.
     * OUTPUT: "Alice, Bob, Alex, Brian, Charlie"
     */
    static String joinComma(List<String> names) {
        return names.stream().collect(Collectors.joining(", "));
    }

    /**
     * WHAT: Joins all names with a custom delimiter, prefix, and suffix.
     * HOW:  Collectors.joining(delimiter, prefix, suffix)
     *         delimiter = " | "  → inserted between each element
     *         prefix    = "["    → prepended to the result
     *         suffix    = "]"    → appended to the result
     * OUTPUT: "[Alice | Bob | Alex | Brian | Charlie]"
     */
    static String joinFormatted(List<String> names) {
        return names.stream()
                .collect(Collectors.joining(" | ", "[", "]"));
    }

    /**
     * WHAT: Groups names by first letter and counts how many fall in each group.
     * HOW:  Collectors.groupingBy(classifier, downstream)
     *         classifier = first character → becomes the Map key
     *         downstream = Collectors.counting() → counts elements in each group
     *       Alice and Alex both start with A → A count = 2
     *       Bob and Brian both start with B  → B count = 2
     *       Charlie starts with C            → C count = 1
     * OUTPUT: {A=2, B=2, C=1}
     */
    static Map<String, Long> countByFirstLetter(List<String> names) {
        return names.stream()
                .collect(Collectors.groupingBy(
                        name -> String.valueOf(name.charAt(0)),
                        Collectors.counting()
                ));
    }

    /**
     * WHAT: Groups names by first letter and joins each group's names into one String.
     * HOW:  groupingBy + mapping + joining as downstream collectors.
     *         groupingBy → creates groups by first letter
     *         mapping(name -> name, joining(", ")) → within each group,
     *           maps each name to itself then joins with ", "
     *       Alice, Alex → "Alice, Alex"
     *       Bob, Brian  → "Bob, Brian"
     * OUTPUT: {A=Alice, Alex, B=Bob, Brian, C=Charlie}
     */
    static Map<String, String> joinNamesByFirstLetter(List<String> names) {
        return names.stream()
                .collect(Collectors.groupingBy(
                        name -> String.valueOf(name.charAt(0)),
                        Collectors.mapping(name -> name, Collectors.joining(", "))
                ));
    }

    /**
     * WHAT: Groups names by first letter and finds the maximum name-length in each group.
     * HOW:  groupingBy → group by first letter
     *       mapping(String::length, maxBy) → convert each name to its length,
     *         then find the max length within the group.
     *       Returns Map<String, Optional<Integer>> from groupingBy,
     *         then a second stream unwraps the Optional via orElse(0).
     *       Group A: Alice(5), Alex(4) → max = 5
     *       Group B: Bob(3),  Brian(5) → max = 5
     *       Group C: Charlie(7)        → max = 7
     * OUTPUT: {A=5, B=5, C=7}
     */
    static Map<String, Integer> maxLengthByFirstLetter(List<String> names) {
        return names.stream()
                .collect(Collectors.groupingBy(
                        name -> String.valueOf(name.charAt(0)),
                        Collectors.mapping(String::length, Collectors.maxBy(Integer::compareTo))
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().orElse(0)  // unwrap Optional
                ));
    }

    /**
     * WHAT: Splits names into exactly two groups — true and false — based on a predicate.
     * HOW:  Collectors.partitioningBy(predicate) always returns Map<Boolean, List<T>>.
     *       predicate = name.length() <= 4
     *       true  group (length ≤ 4): Bob(3), Alex(4)
     *       false group (length > 4): Alice(5), Brian(5), Charlie(7)
     *       Unlike groupingBy, partitioningBy always gives EXACTLY 2 keys: true and false.
     * OUTPUT: {false=[Alice, Brian, Charlie], true=[Bob, Alex]}
     */
    static Map<Boolean, List<String>> partitionByLength(List<String> names) {
        return names.stream()
                .collect(Collectors.partitioningBy(name -> name.length() <= 4));
    }

    /**
     * WHAT: Collects names longer than 4 chars into an UNMODIFIABLE list.
     * HOW:  filter(length > 4) → keeps Alice(5), Brian(5), Charlie(7)
     *       Collectors.collectingAndThen(downstream, finisher)
     *         downstream = toList()      → first collects into a normal List
     *         finisher   = List::copyOf  → then wraps it as an unmodifiable copy
     *       Calling .add() on the result throws UnsupportedOperationException.
     * OUTPUT: [Alice, Brian, Charlie]  (unmodifiable)
     */
    static List<String> unmodifiableLongNames(List<String> names) {
        return names.stream()
                .filter(name -> name.length() > 4)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        List::copyOf  // finisher: makes it unmodifiable
                ));
    }

    /**
     * WHAT: Filters names longer than 4 characters into a regular mutable List.
     * HOW:  filter(predicate) removes elements where predicate is false.
     *       name.length() > 4 keeps: Alice(5), Brian(5), Charlie(7)
     *       Bob(3) and Alex(4) are excluded.
     *       collect(toList()) gathers survivors into a new ArrayList.
     * OUTPUT: [Alice, Brian, Charlie]
     */
    static List<String> longNames(List<String> names) {
        return names.stream()
                .filter(name -> name.length() > 4)
                .collect(Collectors.toList());
    }
}
