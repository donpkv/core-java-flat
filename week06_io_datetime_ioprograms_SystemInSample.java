package ioprograms;

import java.io.*;
public class SystemInSample {
    public static void main(String[] args)  {//throws IOException
        InputStreamReader isr= new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);// it creates buffer memory for inputs given through command prompt
        System.out.println("Enter Something ");
        String userInput = null;
        try {
            userInput = reader.readLine();
        } catch (IOException e) {
            System.out.println("Exception occured: ");
            e.printStackTrace();
        }
        System.out.println("You entered the following: "+userInput);
    }
}