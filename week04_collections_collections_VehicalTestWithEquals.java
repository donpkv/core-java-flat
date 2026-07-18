package collections;
import java.util.HashSet;
public class VehicalTestWithEquals {
    public static void main(String...arg) {
        Pulsar Pulsar1 = new Pulsar(10);
        Pulsar Pulsar2 = new Pulsar(11);
        HashSet hashSet = new HashSet();
        System.out.println("Adding pulsar 1 "+hashSet.add(Pulsar1));
        System.out.println("----------------------------------");
        System.out.println("Adding pulsar 2 "+hashSet.add(Pulsar2));
        }
}
class Pulsar {//extends Object
    int idNumber;
    public Pulsar(int idNumber) {
        this.idNumber =idNumber;
    }
    @Override
    public boolean equals(Object obj) {
        System.out.println("equals called");
        if(obj instanceof Pulsar) { // && ((Pulsar)obj).idNumber ==this.idNumber
            System.out.println("obj instanceof Pulsar");
            if(((Pulsar)obj).idNumber ==this.idNumber)
            {
                System.out.println("idNum are equal");
                return true;
            }
            else {
                System.out.println("idNum are not equal");
                return false;
            }
        }
        else
        { System.out.println("obj not instanceof Pulsar");
            return false;
        }
 }
    public int hashCode() {
        System.out.println("Hashing!!");
        //return idNumber*17;
        return idNumber;
    }
    /*public String toString()
    { return "I M Pulsar!!!";
    }*/
}
