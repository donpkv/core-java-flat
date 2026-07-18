package collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class HashSetElements {
    Set hashSet;
    public HashSetElements(String s1, String s2, String s3, String s4) {
        hashSet = new HashSet();
        System.out.println(hashSet.add(s1));
        System.out.println(hashSet.add(s2));
        System.out.println(hashSet.add(s3));
        System.out.println(hashSet.add(s4));

        //hashSet.equals(s1);
        }
    void displayList() {
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(" --> " + iterator.next());
        }
    }
}
public class SimpleHashSet {
   public static void main(String...ar) {
       HashSetElements hashSetElements = new HashSetElements("A","A","C","c");
       hashSetElements.displayList();
   }
}
