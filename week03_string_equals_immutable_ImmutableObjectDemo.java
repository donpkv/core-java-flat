package immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Immutable object rules:
 * - final class (optional but recommended)
 * - final fields
 * - no setters
 * - defensive copy for mutable fields (List, Date)
 */
final class ImmutablePerson {

    private final String name;
    private final List<String> hobbies;

    public ImmutablePerson(String name, List<String> hobbies) {
        this.name = name;
        this.hobbies = Collections.unmodifiableList(new ArrayList<>(hobbies));
    }

    public String getName() {
        return name;
    }

    public List<String> getHobbies() {
        return hobbies; // already unmodifiable
    }
}

public class ImmutableObjectDemo {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("coding");
        input.add("reading");

        ImmutablePerson person = new ImmutablePerson("Piyush", input);
        input.add("gaming"); // should NOT affect person

        System.out.println(person.getName());
        System.out.println("Hobbies: " + person.getHobbies());
    }
}
