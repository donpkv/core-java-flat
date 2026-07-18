interface A
{

     int VAL=12323456;
     //void designFun();

    public default void method(){
        System.out.println("Method A");
    }
}

interface B
{
    //void designFun();

    public default void method(){

        System.out.println("Method B");
    }
}

class C
{
      public void fun()
        {

            System.out.println("Fun from class C");
        }



}


interface D
{
    //void designFun();
    default void fun()
   {
       System.out.println("Fun from Interface D");


   }
    public default void method(){

        System.out.println("Method D");
    }


}


public class InterfaceAmbiguity extends C implements A,B,D{
    public static void main(String[] ar) {
        new InterfaceAmbiguity().method();
        new InterfaceAmbiguity().fun();
    }
    @Override
    public void method() {
       // System.out.println("Which Method");
        A.super.method();
       B.super.method();
       D.super.method();
    }

/*    public void method() {

        System.out.println("Which Method");
    }*/
}
