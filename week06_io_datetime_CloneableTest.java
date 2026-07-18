
// Java program to illustrate Cloneable interface
import java.lang.Cloneable;

// By implementing Cloneable interface
// we make sure that instances of class Implement
// can be cloned.
class Implement implements Cloneable
{
    int i;
    String s;

    // Implement class constructor
    public Implement(int i, String s)
    {
        this.i = i;
        this.s = s;
    }

    // Overriding clone() method
    // by simply calling Object class
    // clone() method.
    @Override
    protected Object clone()
            throws CloneNotSupportedException
    {
        return super.clone();
    }
}

public class CloneableTest
{
    public static void main(String[] args)
            throws CloneNotSupportedException
    {
        Implement a = new Implement(20, "Hello Cloning");

        // cloning 'a' and holding
        // new cloned object reference in b

        // down-casting as clone() return type is Object
        Implement b = (Implement)a.clone();

        System.out.println(b.i);
        System.out.println(b.s);
    }
}
