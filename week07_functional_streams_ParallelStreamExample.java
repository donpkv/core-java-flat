package streams;

// Java Program to Illustrate Parallel Streams
// Using parallel() method on a Stream

/*
Java Parallel Streams is a feature of Java 8 and higher, meant for utilizing multiple cores of the processor.
 Normally any java code has one stream of processing, where it is executed sequentially.
  Whereas by using parallel streams, we can divide the code into multiple streams
  that are executed in parallel on separate cores and the final result is the combination of the individual outcomes.
 The order of execution, however, is not under our control.

Processor cores are individual processing units within the computer's central processing unit (CPU).
 The processor core receives instructions from a single computing task,
 working with the clock speed to quickly process this information and temporarily store it in the Random Access Memory (RAM)*/
// Importing required classes
import java.io.File;
        import java.io.IOException;
        import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Main class
// ParallelStreamTest
public class ParallelStreamExample {

    // Main driver method
    public static void main(String[] args) throws IOException {

        // Creating a File object
        File fileName = new File("M:\\Documents\\Textfile.txt");
        Path path = Paths.get("M:\\Documents\\Textfile.txt");

        // Create a Stream of string type
        // using the lines() method to
        // read one line at a time from the text file
        //Stream<String> text = Files.lines(fileName.toPath());
        Stream<String> text = Files.lines(path);

        // Creating parallel streams using parallel() method
        // later using forEach() to print on console
        text.parallel().forEach(System.out::println);

        // Closing the Stream
        // using close() method
        text.close();
    }
}
