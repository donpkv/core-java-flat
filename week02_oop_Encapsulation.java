class PswdClass {
    public int getPassword() {
        return password;
 }
  public void setPassword(int password) {
        this.password = password;
    }
   private int password;
}
public class Encapsulation {
    public static void main(String...ar) {
        PswdClass pswdClass = new PswdClass();
        pswdClass.setPassword(1234); // proper way
       // pswdClass.password =1234; // improper
  }

}

class Outer
{
    void accessOuter()
    {
        PswdClass pswdClass = new PswdClass();
        //pswdClass.password =2345;
        pswdClass.setPassword(1234);

        System.out.println(" You password is "+pswdClass.getPassword());

    }


}