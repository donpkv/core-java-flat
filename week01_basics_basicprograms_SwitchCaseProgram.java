package basicprograms;

public class SwitchCaseProgram {

    public static void main(String args[]){
        int intVar =21;
        switch(intVar) {
            case 1:
               String string = "foo";
               System.out.println("Case 1 "+string);
                break;
            case 2:
                string = "bar";
                System.out.println("Case 2 "+string);
                break;
            case 3:
                string = "car";
                System.out.println("Case 3 "+string);
                break;
            default:
                string = "";
                System.out.println("Default  "+string);

        }


    }
}
