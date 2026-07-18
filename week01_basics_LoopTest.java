public class LoopTest {

    public static void main(String args[]) {

        int arr[];
        arr = new int[10];
        int count =0;

        for (int i = 0 ;i< arr.length ; i++)
        {
             arr[i] = ++count;
            System.out.println("Storing counts in array positiong : "+i);

        }

        System.out.println("--------------------------------------");


        for (int i : arr) {

            System.out.println("printing values "+i +" at position in arr");


        }

         if(count<10) {
             count = 10;
         }else {
             count = 5;
         }


        System.out.println("--------------------------------------");

        int val =10;

        switch (val)
         {
             case 10:
                 System.out.println("case 1");

             case 11:
                 System.out.println("case 2");
             case 12:
                 System.out.println("case 3");
             default:
                 System.out.println("No one understood  ");

         }


    }
}