package exceptions;
//import java.io.IOException;
class AgeException extends Exception
{
    String message;

    AgeException(String message)
    {

        this.message =message;

    }

    @Override
    public String toString() {
        return message;
    }

   /*String displayMsg()
   {
       return message;


   }*/

}

class CheckAgeClass
{

          void checkAge(int age) throws AgeException //,IOException
           {

               if(age<18 || age>60)
               {

                  throw new AgeException("AgeException !!!");

               }
               else
               {

                   System.out.println("Valid Age for Recruitment!!");
               }


           }



}

public class UserDefinedException {
    public static void main(String... args) //throws Exception{
    {
        CheckAgeClass checkAgeClass = new CheckAgeClass();
              //checkAgeClass.checkAge(17);
        try {
            checkAgeClass.checkAge(10);
        } catch (AgeException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }

    }
}
