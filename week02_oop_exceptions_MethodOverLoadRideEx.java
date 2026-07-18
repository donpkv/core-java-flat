package exceptions;

import java.io.IOException;

//parent class
class Parent
{   static int a;
    static int b;
//static
  public void method(int a, int b)  throws Exception
    {

        System.out.println("parent  int a ,b");

    }
/*
      int method(int a, float b)
    {

        System.out.println(" static int a ,float b");

     return 0;
    }

     String method(int a, String b)
    {

        System.out.println(" static int a ,String b");

        return "Implement";
    }
*/

}

//child class
class Child extends Parent
{
    //static
    @Override
    public    void method(int a, int b) throws IOException
    {

         System.out.println(" child  int a ,b");

    }

    //static
    int method(int a, float b)
    {

        System.out.println(" child  static int a ,float b");

      return 0;
    }


}

public class MethodOverLoadRideEx {

    public static void main(String[] args) throws Exception{

        Parent parent= new Parent();

        parent.method(1,2);

        Parent child= new Child();

        //child =(Child)parent ;

        child.method(1,2);
      /*  parent.method(1,2.5f);
        parent.method(1,"");

       Child child= new Child();

        child.method(1,2);
        child.method(1,2.5f);
        child.method(1,"");
  */  }

}
