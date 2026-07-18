package equalshashcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Contract: if a.equals(b) then a.hashCode() == b.hashCode()
 * Required for HashMap, HashSet keys.
 */
class Person {

    private final int id;
    private final String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person other)) return false;
        return id == other.id && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Person{id=" + id + ", name='" + name + "'}";
    }
}

public class EqualsHashCodeContractDemo {
    public static void main(String[] args) {
        Person p1 = new Person(1, "Amy");
        Person p2 = new Person(1, "Amy");

        System.out.println("equals: " + p1.equals(p2));
        System.out.println("hashCode same: " + (p1.hashCode() == p2.hashCode()));

        Map<Person, String> map = new HashMap<>();
        map.put(p1, "Employee");
        System.out.println("Lookup with p2: " + map.get(p2));
    }
}
