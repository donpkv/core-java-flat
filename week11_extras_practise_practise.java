package practise;

import java.util.*;
public class practise {
    public static void main(String... args){
        ArrayList<String> str1 = new ArrayList<>();
        str1.add("hey");
        str1.add("1919");
        Iterator<String> it = str1.iterator();
        while(it.hasNext()){
            System.out.println(str1);
            it.remove();
            it.next();

        }
        if(!it.hasNext()){
            System.out.println("Empty");
        }
    }
}
