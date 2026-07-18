package collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
class HashMapElements {
    Map<Integer ,String> hashMap;
    public HashMapElements(String s1, String s2, String s3, String s4){
        hashMap = new HashMap();
        hashMap.put(1,s1);//AutoBoxing keys to object
        hashMap.put(2,s2);//AutoBoxing keys to object
        hashMap.put(3,s3);//AutoBoxing keys to object
        hashMap.put(4,s4);//AutoBoxing keys to object
        System.out.println("Key Values Added");
    }
    void displayList() {
        Set keySet = hashMap.keySet();
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            System.out.println("getting value --> " + hashMap.get(object)+"  from  key "+object);
          }
    }
}
public class HashMapTest {
    public static void main(String...ar) {
        HashMapElements hashMapElements = new HashMapElements("A","A","C","c");
        hashMapElements.displayList();
    }
}
