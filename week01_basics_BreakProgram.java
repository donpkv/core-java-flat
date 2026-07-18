public class BreakProgram { //instance scope
   static boolean flag;
    public static void main(String...args)
    {
     System.out.println(" Flag is "+flag);
         for (int i=0;i<100 && flag==false ;i++) // or i<100 && flag==false   is recommended approach
         {
            //if(flag==false) {
                System.out.println("Break at pos "+i);
                if (i == 30) {
                    flag = true;
                    //break;
                }
            //}
         }



    }

}
