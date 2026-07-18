import java.util.HashMap;
import java.util.HashSet;

public class EqualsTest {

    public static void main(String...arg)
    {
        Moof moof1 = new Moof(8);
        Moof moof2 = new Moof(8);

      /*  String moof1 = "8";
        String moof2 = "9";
        System.out.println(moof1.equals(moof2));
        System.out.println(moof1==moof2);*/
        //HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();

        System.out.println(hashMap.put(moof1,"P1"));
        System.out.println(hashMap.put(moof2,"P2"));

/*
        System.out.println(hashMap.put("P1",moof1));
        System.out.println(hashMap.put("P2",moof2));
*/


        System.out.println("----------------------------------");

        System.out.println(hashMap.get(moof1));
        System.out.println(hashMap.get(moof2));

      /*  System.out.println(hashMap.get("P1"));
        System.out.println(hashMap.get("P2"));*/
  /*      hashMap.put(moof1,"P1");
        hashMap.put(moof2,"P2");
*/
        /*hashMap.put(moof1,"P1");
        System.out.println(hashMap.put(moof2,"P2"));
*/
        /*       String s1 = "a";
        String s2 = "Implement";
        String s3 = new String("HELLO");

        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s1.equals(s2)); // true
        System.out.println(s1.equals(s3)); // true*/
    }




}
class Moof
{
  int mVal;

    public Moof(int mVal) {

        this.mVal=mVal;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("equals called");
        if(obj instanceof Moof)
        {
            System.out.println("obj instanceof Moof");

            //return true;

        }
        else
        {

            System.out.println("obj not instanceof Moof");

            return false;
        }

        if(((Moof)obj).mVal==this.mVal)
        {
            System.out.println("vals are equal");

            return true;
        }
        else {
            System.out.println("vals are not equal");

            return false;
        }

    }
    public int hashCode()
    {
        System.out.println("Hashing!!");

        //return mVal*17;
        return mVal;
    }

    public String toString()
    {

        return "I M Moof!!!";
    }
}