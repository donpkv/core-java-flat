package basicprograms;

public class OperatorTestProgram {

    public static void main(String[] args){
          int num1 =10;
          int num2 =20;
          int sum=0;

          sum = (num1 + num2) * 20;

          /*if(num1 < num2)
          sum=10;
          else
              sum=20;
*/
          sum = num2>num1 ? num2 : num1; //Conditional or Ternary operator

           System.out.println("Sum is "+sum);


    }

}
