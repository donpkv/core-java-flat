package exceptions;
import org.apache.derby.client.am.SqlException;

import java.io.IOException;

public class RethrowExecption {

         static void couldThrowException() throws SqlException,IOException
         {

             try{

                 //couldThrowException();
             }
             catch(Exception e)
             {

                 throw e;
             }

         }


    static void rethrow() throws SqlException,IOException
    {

        try{

            couldThrowException();
        }
        catch(Exception e)
        {

             throw e;
        }

    }

    public static void main(String[] args) {


        try {
            rethrow();
        } catch (SqlException |  IOException e) {
            e.printStackTrace();
        }
/*
        catch (IOException e) {
            e.printStackTrace();
        }
*/



    }
}
