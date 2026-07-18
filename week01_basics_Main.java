import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        System.out.println("------------------Hello World--------------------");
        System.out.println("------------------This is Input Output Program--------------------");

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(isr);

       try {
           System.out.println("Enter values..");
           int charOrIntVal = bufferedReader.read();

           System.out.println("Enter values..");
           String string  =bufferedReader.readLine();

/*
           System.out.println("Enter values..");
           int charOrIntVal = bufferedReader.read();
*/

           //System.out.println(" 1st "+string+" 2nd "+charOrIntVal);
           System.out.println(" 1st "+charOrIntVal+" 2nd "+string);

           //System.out.println(" 2nd "+string);






       }
       catch (Exception e)
       {

           e.printStackTrace();
       }

    }
}
