package InputPrograms;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
 class SortAscNumber{
    SortAscNumber(){
      
     }
     String numberComparator(final int first ,final int sec ,final int thrd ,final int forth) {
         int low=0;
         int high=0;
         if(first <sec && first < thrd && first<forth)
            {
                low =first;

             // low = ;
            }
            else if(sec < first)
            {

            }
            return low+","+sec+","+high;
      }
    void getNumbers() {//
        Scanner scanner = new Scanner(System.in);// new File("")
        System.out.println("Enter The Numbers:");
        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();
        int thirdNum = scanner.nextInt();
        int forthNum = scanner.nextInt();
       String returnVal=  numberComparator(firstNum ,secondNum ,thirdNum ,forthNum);
       System.out.println(" Sorted:{ "+returnVal+ " }");
    }
    public static void main(String...args) throws IOException{
        SortAscNumber  inputProgramTest = new SortAscNumber();
         try {
             inputProgramTest.getNumbers();
         }
         catch (Exception ex)
         {
             System.out.println("Exception Caught");
             ex.printStackTrace();
         }
         }
}
