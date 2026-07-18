package exceptions;

import java.io.*;
import java.util.Scanner;

class Turkey implements AutoCloseable {
    Turkey()
    {

    }
    @Override
    public void close()  {
        System.out.println("Turkey closed!!");

    }
}
class Ukraine implements AutoCloseable {
    Ukraine()
    {

    }
    @Override
    public void close()  {
        System.out.println("Ukraine closed!!");

    }
}

public class TryWithResources {

    public static void main(String...args) throws IOException{
        try (Turkey turkey = new Turkey();Ukraine ukraine = new Ukraine();
            BufferedReader br = new BufferedReader(new Reader() {
                @Override
                public int read(char[] cbuf, int off, int len) throws IOException {
                    return 0;
                }

                @Override
                public void close() throws IOException {

                }
            })) {

        } /*catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        File path=null;
        try (FileReader fr = new FileReader(path);
             BufferedReader br = new BufferedReader(fr)) {
            //return br.readLine();
        }

        try (Scanner scanner = new Scanner(new File("testRead.txt"));
             PrintWriter writer = new PrintWriter(new File("testWrite.txt"))) {
            while (scanner.hasNext()) {
                writer.print(scanner.nextLine());
            }
        }

    }

}
