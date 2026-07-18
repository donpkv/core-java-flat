class AnimalClss {
    void speed() {
       }
}
class TigerClss  extends AnimalClss {
    void speedPlus() {
    }
}
class LionClss  extends AnimalClss {
    void speedPlus()
    {
    }
}
class Liger extends TigerClss// , LionClss
{
    @Override
    void speed() {
    }
}
public class DeadDiamondDesign {
    public static void main(String...args) {
        System.out.println("Multiple inherittence is not supported and looks like dead dimond design to compiler");
        //Multiple inherittence is supported indirectly using interfaces in java
    }
}
