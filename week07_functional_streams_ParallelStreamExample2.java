package streams;
// Java Program to Illustrate Parallel Streams
// using parallelStream() method on a Stream

// Importing required classes
import java.io.File;
        import java.io.IOException;
        import java.nio.file.Files;
        import java.util.*;

// Main class
// ParallelStreamsTest
public class ParallelStreamExample2 {

    // Main driver method
    public static void main(String[] args)
            throws IOException
    {

        // Creating a File object
        File fileName
                = new File("M:\\Documents\\List_Textfile.txt");

        // Reading the lines of the text file by
        // create a List using readAllLines() method
        List<String> text
                = Files.readAllLines(fileName.toPath());

        // Creating parallel streams by creating a List
        // using readAllLines() method
        text.parallelStream().forEach(System.out::println);
    }
}

