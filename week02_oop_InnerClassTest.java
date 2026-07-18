class OuterClass
{

   static int outerVal=30;
        void display()
        {
            final int[] var = {0};

             var[0] =10;


             class MethodLocal
                        {

                            void changeDisplayVariable()
                            {

                                 var[0] =10;
                            }


                        }

            MethodLocal methodLocal = new MethodLocal();
            methodLocal.changeDisplayVariable();

        }

       static class InnerClass
        {
               void innerFun()
               {
                   outerVal =40;

                   System.out.println("Value changed from Innerclass "+outerVal);



               }


        }






}

interface InnerDesign
{
    int design();

        class InterfaceClass
        {
            interface BI
            {
                class CI
                {

                }

            }
            enum A{


            }
        }
}


class Impl implements InnerDesign
{
    @Override
    public int design() {
        return 0;
    }

    void fun(InnerDesign locDesign)
    {

        //return 0;
    }

}

public class InnerClassTest {

    public static void main(String args[]) {
        /*OuterClass.InnerClass obj =new OuterClass().new InnerClass();
        obj.innerFun();
        *///OuterClass.InnerClass l=new OuterClass.InnerClass();

        //(new OuterClass().new InnerClass()).innerFun();

        //OuterClass.InnerDesign obj = new OuterClass.InnerDesign
        InnerDesign obj = () -> {System.out.println("");
        return 0;
           };


        new Impl().fun(() -> 0);
    }

    }
