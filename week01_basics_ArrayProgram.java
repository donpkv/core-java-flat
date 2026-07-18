
public class ArrayProgram {

    public static void main(String args[]) {
       int[] arr = new int[5];


        int[][] mdArr = new int[3][3];

        int count=0;

        for (int idx = 0 ;idx<mdArr.length;idx++)
        {
            for (int idxCol =0 ; idxCol<3; idxCol++) {
                System.out.println("Storing values in 2dArray");
                mdArr[idx][idxCol] = ++count;

            }

        }

        System.out.println("------------------------------------");


        for (int idx = 0 ;idx<mdArr.length;idx++)
        {
            for (int idxCol =0 ; idxCol<3; idxCol++)
            {
                System.out.println("printing values from 2d at "+ " row "+idx+" col "+idxCol +"  are "+mdArr[idx][idxCol]);
            }


        }




       char[] charArr = new char[5];

        charArr[0]='1';
        charArr[1]=' ';
        charArr[0]='a';
        charArr[0]='b';
        charArr[0]='1';

        UserDefArray[] userArray = new UserDefArray[10];
        userArray[0]= new UserDefArray();
        userArray[1]= new UserDefArray();
        userArray[2]= new UserDefArray();
        userArray[3]= new UserDefArray();
        userArray[4]= new UserDefArray();

        arr[0]=100;
        arr[1]=200;
        arr[2]=300;
        arr[3]=400;
        arr[4]=500;


    }


    }

  class UserDefArray
  {






  }
