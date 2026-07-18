
 abstract class AbstractClass {
     AbstractClass() {
         System.out.println("Abstract Class Constructor");

     }
     abstract void abstractFun();
    void nonAbstractFun()
     {
           System.out.println("Abstract Fun");
     }

}

class ImplementationClass1 extends AbstractClass
{
    private int hiddenVar=10;
    @Override
    void abstractFun() {
        System.out.println("Abstract Fun implemented through implmentation class 1!!!");

    }
    ImplementationClass1()
     {
         //super();
         System.out.println("ImplementationClass1 Constructor");


     }

}

 class ImplementationClass2 extends AbstractClass
 {
     private int hiddenVar=10;
     @Override
     void abstractFun() {
         System.out.println("Abstract Fun implemented through implmentation class 2!!!");

     }
     ImplementationClass2()
     {
         //super();
         System.out.println("ImplementationClass2 Constructor");


     }

 }

class InteractionClass
{

      void interactMethod(AbstractClass abstractClassObj)
      {
          abstractClassObj.abstractFun();

      }

}


public class AbstractClassTest {


    public static void main(String...args)
    {

       //  AbstractClass abstractClass = new AbstractClass();
        AbstractClass abstractClass1 = new ImplementationClass1();
        AbstractClass abstractClass2 = new ImplementationClass2();
        InteractionClass interactionClass = new InteractionClass();
        interactionClass.interactMethod(abstractClass1);
        interactionClass.interactMethod(abstractClass2);

    }

}
