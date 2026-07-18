package functionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.ToIntFunction;

public class ConsumerInterfaceExample2 {
     static long addList(List<Integer> list){
        // Return sum of list values
        long result = list.stream()
                .mapToInt(integer -> integer.intValue()).count();

        /* long result = list.stream()
                 .mapToInt(new ToIntFunction<Integer>() {
                     @Override
                     public int applyAsInt(Integer integer) {
                         return integer.intValue();
                     }
                 }).count();*/
                //.sum();
        System.out.println("Sum of list values: "+result);
      return result;
    }
    public static void main(String[] args) {
        // Creating a list and adding values
        List<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
       // Consumer<List<Integer>> consumer = new ConsumerInterfaceExample2()::addList; // reference to instance(non-static) method
        Consumer<List<Integer>> consumer = ConsumerInterfaceExample2::addList;
        consumer.accept(list);  // Calling Consumer method

    }
}

