class VarArgs
{

      void passArgs(float b,int...val)
      {
          for (int value : val) {

          System.out.println(value);

      }


      }


}


public class VarArgsProgram {

    public static void main(String...args) {
        VarArgs varArgs = new VarArgs();
        varArgs.passArgs(2.5f,1,2,3,4,5,8,9,10,11);
    }
}
