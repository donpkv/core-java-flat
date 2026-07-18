public class StaticAndDefaultMethods {
 public static void main(String...args)
 {
     Fly eagle = new Eagle();
     try {
         eagle.getWingSpan();

     } catch (Exception e) {
         e.printStackTrace();
     }
     eagle.land();
     System.out.println("Eagle is diving fast"+Fly.calculateSpeed(100,3));



 }

}
 interface Fly {
    public int getWingSpan() throws Exception;//Abstract Fun
    public static final int MAX_SPEED = 100; //Constants

    public default void land() {        //Default Method
        System.out.println("AnimalClass is landing");
    }

    public static double calculateSpeed(float distance, double time) {//Static Method
        return distance/time;
    }
}

class Eagle implements Fly {
    @Override
    public int getWingSpan() {      return 15;
    }

    public void land() {      System.out.println("Eagle is diving fast");
    }
}
