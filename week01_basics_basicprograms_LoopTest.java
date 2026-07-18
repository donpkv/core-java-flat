package basicprograms;
public class LoopTest {
    public static void main(String args[]) {
        int[] arr;
        arr = new int[10];
        int count =0;
        for (int i = 0 ;i< arr.length ; i++) {
             arr[i] = ++count;
            System.out.println("Storing counts in array position : "+i);
        }

        System.out.println("--------------------------------------");

        int pos=0;

        for (int i : arr) { //for each loop or enhanced for loop

            System.out.println("printing values "+i +" at position "+pos+" in int array");

            pos++;

        }


    }
}