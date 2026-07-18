package basicprograms;

class PasswordProgram
{
    private int password;
    private int intVar;
    public void setPassword(int password) {
        this.password = password;
    }
}
public class EncapsulationProgram {

             public static void main(String...args)
             {
                 PasswordProgram passwordProgram = new PasswordProgram();
                 passwordProgram.setPassword(1234);
                 //passwordProgram.password=1234;

             }

}
