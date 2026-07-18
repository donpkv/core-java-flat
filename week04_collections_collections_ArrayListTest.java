package collections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
// Storing elements in collections , performing traversal & sorting
class ArrayElements
{
    List arrayList;
    List<Integer> listElemnts;
    ArrayElements(String intVal, String abc, String aFloat) {
        arrayList = new ArrayList();
        arrayList.add(intVal);
        arrayList.add(abc);
        arrayList.add(aFloat);
       /* arrayList.add(10); //autoboxing
        arrayList.add(10);
        arrayList.add(20.5f);
        arrayList.add('a');
        arrayList.add('b');
*/
    }
    ArrayElements(List<Integer> listElements)
    {
        this.listElemnts = listElements;
        System.out.println("List Elements "+this.listElemnts);

        for (int i = 0; i < listElements.size(); i++) {
            Integer name =  listElements.get(i);    // () class cast exception here
            System.out.println(name);
        }
    }

    List displaySecondList()
    {
        if(listElemnts!=null && listElemnts.size()>0) {
            System.out.println("1st output of ArrayList : "+listElemnts);
            System.out.println("2nd output of ArrayList : ");
            Iterator iterator = listElemnts.iterator();
            while (iterator.hasNext()) {
                //int val= (int)iterator.next();
                System.out.println(" --> "+iterator.next());

            }
            return listElemnts;
        }

        return null;
    }

    List displayList()
    {
        if(arrayList!=null && arrayList.size()>0) {
            System.out.println("1st way of displaying ArrayList : "+arrayList);
            System.out.println("2nd way of displaying ArrayList : ");
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
               //int val= (int)iterator.next();
               System.out.println(" --> "+iterator.next());

            }
            return arrayList;
        }

       return null;
    }
    /*void displayList()
    {
        if(arrayList!=null && arrayList.size()>0) {
            System.out.println("1st output of ArrayList : "+arrayList);
            System.out.println("2nd output of ArrayList : ");
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
               //int val= (int)iterator.next();
               System.out.println(" --> "+iterator.next());

            }
        }
    }*/

    void performSort()
    {
        Collections.sort(arrayList);
    }
}
public class ArrayListTest {
     public static void main(String...ar) {
         System.out.println("Adding elements to ArrayList Collection by passing args to constructor");
         ArrayElements arrayElements = new ArrayElements("20","abc","20.5f");
        System.out.println("----Before Performing sort operation -----");
         arrayElements.displayList();
        System.out.println("----Performing sort operation on ArrayList Collection-----");
         arrayElements.performSort();
         System.out.println("----After Sorting ArrayList Collection-----");
         arrayElements.displayList();
         List returnedList= arrayElements.displayList();
         //send list directly to Constructor
         ArrayElements arrayElements1 = new ArrayElements(returnedList);

         /*System.out.println(" ----------------------------------------------------------------");
         ArrayList arrayList = new ArrayList();

         arrayList.add("B");
         arrayList.add(2.5f);
         arrayList.add('c');
         ArrayElements arrayElements2 = new ArrayElements(arrayList);
         arrayElements2.displaySecondList();*/
/*
         System.out.println(" ----------------------------------------------------------------");

         ArrayElements arrayElements2 = new ArrayElements(returnedList);
         arrayElements2.displaySecondList();
*/

     }
}
