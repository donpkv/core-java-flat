class Another
{
    class AnotherClass
          { void otherClassInnerFun()
              {
                  System.out.println("AnotherClass Inner Method");
                   class MethodLocalInnerClass
                   {
                         void displayMehtodLocFun()
                         {
                             System.out.println("displayMehtodLocFun Inner Method");
                         }
                   }
                  MethodLocalInnerClass methodLocalInnerClass = new MethodLocalInnerClass();
                  methodLocalInnerClass.displayMehtodLocFun();
              }
          }
}

interface DesignInterface
{     //public static final int var=10;
        int var=10;
        int designFun();
}

public class InnerWithAnonymousClass {//implements DesignInterface
    static class InnerClass {
             void innerFun() {
                 System.out.println("Inner Class Method");
                 /*DesignInterface designInterface = new InnerWithAnonymousClass();
                 designInterface.designFun();
                 */
                 DesignInterface designInterface = new DesignInterface() {
                     @Override
                     public int designFun() {
                         System.out.println(" Anonymous Class Method");
                         return 0;
                     }
                 };
                 designInterface.designFun();


                 DesignInterface designInterface1 = () -> {
                     System.out.println(" Anonymous Class Method");
                     return 0;
                 };
                 designInterface1.designFun();

             }

       }
    public static void main(String args[]) {
        InnerClass innerClass = new InnerClass();
        innerClass.innerFun();
        Another.AnotherClass anotherClass = new Another().new AnotherClass();
        anotherClass.otherClassInnerFun();
    }
}