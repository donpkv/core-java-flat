package ioprograms;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
public class ConsoleSample {
    void useOldWay() {
        System.out.println("Using oldway...");
        InputStreamReader isr= new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);
        System.out.println("Enter Something ");
        String userInput = null;
       try {
            userInput = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("You entered the following: "+userInput);

    }
    Console useNewWay() {
        System.out.println("Using newway...");
        Console  console = System.console();
        if(console != null) {
            System.out.println("Enter Something ");
            String userInput = console.readLine();
            console.writer().println ("You entered the following: "+userInput);
          return console;
        } else {
            System.out.println("No Access to Console returning "+console);
            return console;
        }
    }
    public static void main(String[] args) {
        ConsoleSample consoleSample = new ConsoleSample();
       // Console console =consoleSample.useNewWay();
        if(consoleSample.useNewWay()!=null)//console !=null
             {
        }
        else {
            consoleSample.useOldWay();
        }
    }
}
