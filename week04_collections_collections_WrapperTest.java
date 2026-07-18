package collections;
class Wrapper{
   Integer wrapToInt;
   Float   wrapToFloat;
    int val;
    float aFloat;
    Wrapper(int intVal, String string)
    {
        wrapToInt = new Integer(intVal);//Boxing
        wrapToInt = intVal;//AutoBoxing is available from jdk1.5
        val = wrapToInt.intValue();//unBoxing
        val =  wrapToInt;// AutoUnBoxing is available from jdk1.5
        //wrapToInt = new Integer(string);
        wrapToFloat = new Float(2.5f);
        wrapToFloat = 2.5f;
        float floatValOld= wrapToFloat.floatValue();
        float floatValNew= wrapToFloat;

        val= Integer.parseInt(string);//"20";
        aFloat= Float.parseFloat(string);
        /*char ch='a';
        val=string;*/
    }
}
public class WrapperTest {
    public static void main(String...args) {
        Wrapper wrapper = new Wrapper(40,"20");
    }
}
