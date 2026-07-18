//package packname;
import java.util.ArrayList;
import java.util.List;
class SimpleCollection
{
    //List<Integer> arrayList;
    List arrayList;
    SimpleCollection(List arrayList) {
        if(arrayList!=null && arrayList.size()>0) {
            this.arrayList = arrayList;
        }
        else
        {

        }
    }
   List printDinamicArray() {
        return arrayList;
    }
}
public class CollectionTest {
   public static void main(String...args) {
       List arrayList = new ArrayList();
       arrayList.add("A");
       arrayList.add(2.5);
       arrayList.add(10);
       arrayList.add('A');
       SimpleCollection simpleCollection = new SimpleCollection(arrayList);
       List returnArrElement = simpleCollection.printDinamicArray();
       if(returnArrElement!=null && returnArrElement.size()>0)
       System.out.println("Array elements are "+ returnArrElement);
       else
           System.out.println("No elements found in Array ");
   }
}


/*
    byte intVar = 127;
    Byte byteObj = new Byte(intVar); // Boxing
    byte assignBack = byteObj.byteValue(); // UnBoxing
    Byte byteObjAuto = intVar; // AutoBoxing jdk1.5
       intVar =  byteObjAuto;   //auto unboxing;
*/


