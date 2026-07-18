package collections;

import java.util.ArrayList;
import java.util.List;

public class ClassCastExTest {

    static void printNames(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String name =  list.get(i);    // (String) class cast exception here
                    System.out.println(name);
        }
    }
        public static void main(String[] args) {
        List names = new ArrayList();
        names.add(new StringBuilder("Webby"));//StringBuilder("Webby")
        try {
            printNames(names);
        }
        catch (ClassCastException ex)
        {
            System.out.println("StringBuilder Cannot be coverted to String!!! ");
            ex.printStackTrace();

        }
        catch (Exception ex)
        {
            ex.printStackTrace();

        }
        }
}
