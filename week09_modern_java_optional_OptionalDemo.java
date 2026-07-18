package optional;

import java.util.Optional;

/**
 * Optional avoids NullPointerException when used correctly.
 * Do NOT use Optional for fields/parameters everywhere — mainly for return types.
 */
public class OptionalDemo {

    public static void main(String[] args) {
        Optional<String> present = Optional.of("Java");
        Optional<String> empty = Optional.empty();

        System.out.println("present value: " + present.orElse("default"));
        System.out.println("empty value: " + empty.orElse("default"));

        present.ifPresent(v -> System.out.println("ifPresent: " + v.toUpperCase()));

        Optional<String> fromNullable = findUser(2);
        System.out.println("findUser(2): " + fromNullable.orElse("Unknown"));

        Optional<String> missing = findUser(99);
        System.out.println("findUser(99): " + missing.orElse("Unknown"));

        // map + flatMap
        Optional<Integer> length = present.map(String::length);
        System.out.println("length: " + length.orElse(0));

        // orElseThrow
        try {
            missing.orElseThrow(() -> new IllegalArgumentException("User not found"));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }

    static Optional<String> findUser(int id) {
        if (id == 2) {
            return Optional.of("Piyush");
        }
        return Optional.empty();
    }
}
