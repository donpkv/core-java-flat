package ioprograms;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataIOStreamTest {

     public static void main(String...args)
     {
         DataInputStream dataInputStream = new DataInputStream(System.in);
         try {
             dataInputStream.readInt();
         } catch (IOException e) {
             e.printStackTrace();
         }


         try {
             DataInputStream dataInputStreamForFile = new DataInputStream(new FileInputStream("D:\\Data\\file.txt"));
             dataInputStream.readChar();
         } catch (IOException e) {
             e.printStackTrace();
         }

     }

}
