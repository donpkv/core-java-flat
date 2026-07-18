class Genrics<T,A>
{
    T t;
    A a;
    Genrics(T t , A a)
    {
        this.t =t;

        this.a =a;

    }

   T print()
    {
        return t;
    }

    A display()
    {
        return a;
    }

}



public class GenericsTest {

     public static void main(String...args)
     {

         Genrics<Integer,String> genrics = new Genrics("","Hello");

         System.out.println("T is "+genrics.print()+" A is "+genrics.display());
     }

}
