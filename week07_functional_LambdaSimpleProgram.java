interface LambdaFun
{

          int lambdaMethod(LambdaFun obj);



}

class ImplementLambda implements LambdaFun
{


    @Override
    public int lambdaMethod(LambdaFun obj) {
        System.out.println("This is 1st line");
        System.out.println("This is 2nd line");

        return 0;
    }
}



public class LambdaSimpleProgram {


             public static void main(String...args)
             {
                LambdaFun obj = new ImplementLambda();

                 obj.lambdaMethod( new LambdaFun() {
                     @Override
                     public int lambdaMethod(LambdaFun obj1) {
                         System.out.println("This is 3rd line");//this is not printed
                         return 10;
                     }


                 }
                 );
             }


}
