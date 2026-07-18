public class SimpleAssumptionProgram {

      public static void main(String...args)
      {
          int num= -1;

          if(num>0)
          {
              System.out.println("Num is  "+num);


          }
          else
          {
              testAsuumption(num);
          }

      }

      private static void testAsuumption(int num)
      {
              assert(num>0) : " Its ok ";  // assertions are enabled at run time

      }

}
