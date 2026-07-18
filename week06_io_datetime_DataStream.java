/*
import java.io.*;

class DataStream
{
    public static void main(String args[])
    {
        try {

            BufferedReader d = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\java_files\\programs\\abc.txt")));
            DataOutputStream o = new DataOutputStream(new FileOutputStream("temp"));

            String line;
            while((line= d.readLine())!= null)
            {
                String a = (line.toUpperCase());
                System.out.println(a);
                o.writeBytes(a +"\n");
            }

            d.close();
            o.close();
        }
        catch (IOException io)
        {

        }

    }
}
	*/
