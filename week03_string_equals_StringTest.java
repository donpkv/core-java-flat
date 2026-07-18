
public class StringTest {
    public static void main(String args[]) { //Stack Memory  vdp
        String string1 = new String("abc");// forming heap
        String string2 = "abc"; //  keep this abc in string pool
        String string3 = "abc";

        System.out.println("String 1 : "+string1);
        System.out.println("String 2 : "+string2);
        System.out.println("String 3 : "+string3);

        System.out.println("string1 == string2 "+(string1==string2));
        System.out.println("string2 == string3 "+(string2==string3));

        StringBuffer strBuffer1 = new StringBuffer("ddd");
        StringBuffer strBuffer2 = new StringBuffer("ddd");

        System.out.println("strBuffer1==strBuffer2 "+(strBuffer1==strBuffer2));

        StringBuilder strBuilder1 = new StringBuilder("ddd");
        StringBuilder strBuilder2 = new StringBuilder("ddd");
        System.out.println("strBuffer1.equals(strBuffer2) "+(strBuffer1.equals(strBuffer2)));
        System.out.println("strBuilder1.equals(strBuffer1) "+(strBuilder1.equals(strBuffer1)));


        //If you are going to choose between StringBuffer and StringBuilder
        // you need to understand multithreading




    }
}