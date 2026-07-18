package exceptions;


import java.io.IOException;

class FlyClass {
    public void getWingSpan() throws IOException{

    }//Abstract Fun
    public static final int MAX_SPEED = 100; //Constants

    public  void land() {        //Default Method
        System.out.println("AnimalClass is landing");
    }

    public static double calculateSpeed(float distance, double time) {//Static Method
        return distance/time;
    }
}

class Hawk extends FlyClass
{
    public void getWingSpan()  {
        System.out.println("Hawk is diving fast");

    }

}

public class UnreportedException {
    public static void main(String...args) {
        FlyClass flyClass = new Hawk();
        try {
           flyClass.getWingSpan();

        } catch (Exception e) {
            e.printStackTrace();
        }
        flyClass.land();
        System.out.println("Eagle is diving fast"+ flyClass.calculateSpeed(100,3));
        //Now Remove same from from above
       /* FlyClass flyClass = new Hawk();
        flyClass.getWingSpan();
*/
    }

}