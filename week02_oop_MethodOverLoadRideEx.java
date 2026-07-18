
import java.io.IOException;

//parent class
 class Parent
{    int a=10;
    int b;
//static
   public void method(int a, int b) //throws Exceptio
     {

    System.out.println("parent  int a ,b");
  }
    public  static int method(int a, float b,int c) {

        System.out.println("parent static int a ,float b");

     return 0;
    }

    String method(int a, String b) {

        System.out.println(" static int a ,String b");

        return "Implement";
    }

    void searchFun()
    {

        System.out.println("Parent");
    }


}
//child class
class Child extends Parent
{
    //static
    public void method(int a, int b)// Method Overriding
    {


         System.out.println(" child  int a ,b");

    }

    public  static int method(int a, float b,int c) {

        System.out.println("child static int a ,float b");

        return 0;
    }

    void searchFun()  // this is not overriding method
    {
        super.a=20;
        super.searchFun();
        System.out.println("Child");

    }

}

public class MethodOverLoadRideEx {

    public static void main(String[] args) {

        Parent parent= new Parent();
        parent.method(1,2);
        parent.method(1,2.5f,3);

        Parent child= new Child();
        child.method(10,20);
        child.method(1,2.5f,3);


        //child.searchFun();
     /*   Child child2= new Child();
        child2.method(10,20);*/

/*
        Child child2= new Child();
        child2.method(10,20);

        child2.searchFun();
*/

        //child =(Child)parent ;

        //child.method(1,2);
      /*  parent.method(1,2.5f);
        parent.method(1,"");

       Child child= new Child();

        child.method(1,2);
        child.method(1,2.5f);
        child.method(1,"");
  */  }

}
