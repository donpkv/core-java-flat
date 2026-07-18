package collections;

import java.util.HashSet;

class Lion {
    private int idNumber;
    private int age;
    private String name;
    public Lion(int idNumber, int age, String name) {
        this.idNumber = idNumber;
        this.age = age;
        this.name = name;
    }
    @Override
    public boolean equals(Object obj) {
        System. out .println("Equals called!!");
        if ( !(obj instanceof Lion)) return false;
        Lion otherLion = (Lion) obj;
        return this.idNumber == otherLion.idNumber;
    }

   public int hashCode() //remove or comment hashCode and check if equals is called
    {
        System. out .println("Hashing!!");


        return idNumber;
    }

}
public class EqualsOverriding {
    public static void main(String...ar)
    {
        Lion lion1 = new Lion(8,50,"Lion1");
        Lion lion2 = new Lion(8,50,"Lion2");

        HashSet hashSet = new HashSet();
        System. out .println(hashSet.add(lion1));
        System. out .println(hashSet.add(lion2));

        /*String s1 = new String("lion");
        String s2 = new String("lion");

        System. out .println(s1.equals(s2));                  // true

        StringBuilder sb1 = new StringBuilder("lion");
        StringBuilder sb2 = new StringBuilder("lion");
*/

    }
}
