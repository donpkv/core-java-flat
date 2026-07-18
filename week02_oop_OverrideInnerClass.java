import org.apache.derby.client.am.SqlException;

import java.sql.SQLException;

public class OverrideInnerClass {
}

 class LearnToWalk {
    public void toddle() {}

//
}

class BabyRhino extends LearnToWalk {      // INSERT CODE HERE
    /*
    Wrong
    @Override
    public static void toddle() {}
*/
   /* public void toddle() {}

    @Override
    public final void toddle() {}
*/
    /*
    Wrong
    public static void toddle() {}
    */
     /*Wrong
    @Override
    public void toddle() throws Exception {}
*/

    /*Wrong
    @Override
    public void toddle(boolean fall) {}*/
}

  class Outr {
    class Inner {
    }

   /* public static void main(String[] args) {
        // INSERT CODE HERE   }
        //Inner in = new Inner();
        //Inner in = Outer.new Inner();
        //Outr.Inner in = new Outr.Inner();
        //Outr.Inner in = new Outr().Inner();
        Outr.Inner in = new Outr().new Inner();
        //Outr.Inner in = Outr.new Inner();
    }
*/
}




class FourLegged {   String walk = "walk,";
    public static void main(String[] args) {
    FourLegged f = new BabyRino();
        BabyRino b = new BabyRino();
    System. out .println(f.walk);
    System. out .println(b.walk);

    int[] arr = new int[4];
        arr = new int[5];


        String s1 = "Canada";
        String s2 = new String(s1);
        if(s1 == s2) System. out .println("s1 == s2");
        if(s1.equals(s2)) System. out .println("s1.equals(s2)");


    }
}
class BabyRino extends FourLegged {
    String walk = "toddle,";   }



 interface CanClimb {    public abstract void climb();  }   interface CanClimbTrees extends CanClimb {}
  abstract class Chipmunk implements CanClimbTrees {
      public abstract void chew();
}
  abstract class EasternChipmunk extends Chipmunk {
    public void chew() { System.out.println("Eastern Chipmunk is Chewing"); }

      /*@Override
      public void climb() {

      }*/
  }

interface CanFly {
    void fly();
    interface Inter
    {
        class Int
        {

        }
    }
}
interface HasWings {
    public abstract Object getWingSpan();
}
abstract class Falcon implements CanFly, HasWings {

   protected Falcon()
    {
       CanFly.Inter.Int intObj = new CanFly.Inter.Int();
    }

    int val;
    public static void read() throws SQLException
    {
        //val=10;
        throw new SQLException();
    }
}


