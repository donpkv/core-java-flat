package nioprograms;

import java.io.*;
import java.nio.file.*;
public class PathFilePathTest {
    public static void printPathInformation(Path path) {
    System.out.println("Filename is: "+path.getFileName());
    System.out.println("Root is: "+path.getRoot());

    Path currentParent = path;
    while((currentParent = currentParent.getParent()) != null)
    {         System.out.println("   Current parent is: "+currentParent);
    }
    }
    public static void main(String[] args)
    {
        /*Path path = Paths.get("D:\\data\\zoo.txt");
        printPathInformation(path);//"/zoo/armadillo/shells.txt"
        System.out.println();
        */
        //printPathInformation(Paths.get("armadillo/shells.txt"));

        Path file = Paths.get("D:\\data\\zoo.txt");
/*
        try (InputStream in = Files.newInputStream(file); BufferedReader reader = new BufferedReader(new InputStreamReader(in)))
        {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);       }
        }  catch (IOException x)
        {     System.err.println(x);
        }
*/
        try (BufferedReader in = Files.newBufferedReader(file))
        {
            String string ="";
            while ((string=in.readLine())!=null){
                System.out.println(string);

               }
        } catch (IOException e) {
            e.printStackTrace();
        }



        /*try {
            if (Files.isSameFile(path, file)) {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }



    }
