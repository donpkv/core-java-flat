package exceptions;

public class IndxOutOfBoundExcption {


    public static void main(String...args)
    {
        int divResult=0;
        try {
            String text = "text";
            System.out.println(text.charAt(3));
            divResult = 10/0;



               try {


               }
               catch (Exception e)
               {

               }
               finally {
                         //connection.close();

               }

        }

        catch(IndexOutOfBoundsException e) {
            System.err.println("Index out of bounds");
            e.printStackTrace();
        }
        catch(ArithmeticException e) {
            System.err.println("Div by zero Exception");
            e.printStackTrace();
        }

        catch(Exception e) {
            System.err.println("Exception unknown ");
            e.printStackTrace();
        }


    }

}
