interface I1
{
    int VAL=12323456;
     void method1();
     void method2();
}

interface I2
{
    void method2();
}

interface I3 {
    void fun1();

}

interface I4 {
    void fun2() ;

}

  class Implementer implements I1,I2,I3,I4
  {
      @Override
      public void method1() {

          System.out.println("I1");
      }

      @Override
      public void method2() {

          System.out.println("I2");

      }

      @Override
      public void fun1() {

          System.out.println("I3");

      }

      @Override
      public void fun2() {
          System.out.println("I4");

      }
  }

  class Interaction
  {

         void interact(I1 i1,I2 i2,I3 i3,I4 i4)
         {

             i1.method1();
             i2.method2();
             i3.fun1();
             i4.fun2();


         }

  }

    public class Abstraction {


    public static void main(String...args)
    {
        I1 i1 = new Implementer();
        I2 i2 = new Implementer();
        I3 i3 = new Implementer();
        I4 i4 = new Implementer();

        Interaction interaction = new Interaction();

         interaction.interact(i1,i2,i3,i4);


        ((Implementer) i1).method1();
        ((Implementer) i2).method2();

        ((Implementer) i3).fun1();
        ((Implementer) i4).fun2();

    }

}
