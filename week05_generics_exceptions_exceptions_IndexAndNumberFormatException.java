package exceptions;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IndexAndNumberFormatException {
    IndexAndNumberFormatException()
    {
    }

    public static void testScanIntOrDouble() {
        Scanner sin = new Scanner(System.in);
        System.out.println("Enter a double: ");
        while (!sin.hasNextInt()) {//or hasNextDouble()
            System.out.println("Invalid double, shoot again:");
            sin.nextLine();
        }
        double d = sin.nextInt(); //Double()
        System.out.println("Read double value: "+d);
        sin.close();
    }
    void callFuncationality() {
        System.out.println("Funcationality called!!!");
    }
    public static void main(String...args){
        int num =10;
        int result=0;

        try {
            Scanner scanner = new Scanner(new File(""));// or System.in

                  System.out.println("Enter The Number:");
                  int inputAtRunTime=scanner.nextInt();//0

                 /* IndexAndNumberFormatException indexAndNumberFormatException =null ;
            //indexAndNumberFormatException =  new IndexAndNumberFormatException();
            indexAndNumberFormatException.callFuncationality();
*/
            //throw new NullPointerException();
           /* int inputAtRunTime=scanner.nextInt();//0
              result =num/inputAtRunTime;
            System.out.println("Result is "+result);*/

         /*   String text ="abcd";
            System.out.println(text.charAt(10));
         */   //int n = Integer.parseInt(text);
        }
       /* catch(InputMismatchException e) {
            System.err.println("InputMismatch Error!!");
            e.printStackTrace();
        }*/
        catch(ArithmeticException e) {
            System.err.println("Arithmetic Error!!");
            e.printStackTrace();
        } catch(IndexOutOfBoundsException e) {
            System.err.println("Index out of bounds!!");
            e.printStackTrace();
        } catch(NullPointerException e) {
            System.err.println("Null pointer !!");
            e.printStackTrace();
        } catch(NumberFormatException e) {
            System.err.println("bad number");
            e.printStackTrace();
        }
        catch(Exception e) {
                  System.err.println("catching exception by super class Exception!!");
                  e.printStackTrace();
              }
        finally {

                   System.err.println("Finally executed !!");
               }



    }
}







