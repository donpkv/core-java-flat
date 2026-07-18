import java.io.*;


// Java program to illustrate Serializable interface


// By implementing Serializable interface
// we make sure that state of instances of class ImplementSerializable
// can be saved in a file.
class ImplementSerializable implements Serializable
{
    int i;
    String s;
     static int id =1234;

    // ImplementSerializable class constructor
    public ImplementSerializable(int i, String s)
    {
        this.i = i;
        this.s = s;
        id =23;
    }
}

public class SerializableTest
{
    public static void main(String[] args)
            throws IOException, ClassNotFoundException
    {
        ImplementSerializable a = new ImplementSerializable(20,"GeeksForGeeks");

        // Serializing 'a'
        FileOutputStream fos = new FileOutputStream("xyz.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(a);

        // De-serializing 'a'
        FileInputStream fis = new FileInputStream("xyz.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ImplementSerializable b = (ImplementSerializable)ois.readObject();//down-casting object
        //b.id=34;
        System.out.println(b.i+" "+b.s+" "+ImplementSerializable.id);

        // closing streams
        oos.close();
        ois.close();
    }
}
