package ioprograms;
import java.io.*;
import java.util.*;
// CopyTextFileSample program will read from one file and write to other
public class CopyTextFileSample {
    public static List<String> readFile(File source) throws IOException {
        List<String> data = new ArrayList<String>(); // it can store elements of different types
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String s;
            while ((s = reader.readLine()) != null) {
                System.out.println("reading " + s + " from " + source.getName());
                data.add(s);
            }
        }


        return data;
    }

    public static void writeFile(List<String> data, File destination) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            for (String s : data) {
                System.out.println("writing " + s + " to " + destination.getName());

                writer.write(s);
                writer.newLine();
            }
        }
    }

    public static void main(String[] args) throws IOException{//
        File source = new File("D:\\data\\zoo.txt");
        File destination = new File("D:\\data\\zoocopy.txt");
        List<String> data = null;
        //try {
            data = readFile(source);

            for (String record : data) {
                System.out.println(record);
            }
            writeFile(data, destination);
            System.out.println("read write task executed properly!!");


        /*} catch (IOException e) {
            e.printStackTrace();
        }*/

    }

}


class MyAutoClosableClass implements AutoCloseable
{


    @Override
    public void close() throws Exception {

    }
}

