abstract class AbstractDesign {
    abstract void abstractMethod();
    abstract void abstractMethod2();
    void  module1(){
    }
    void  module2(){
    }
}
class AbstractDesignImpl extends AbstractDesign
{
    @Override
    void abstractMethod() {
        System.out.println("Calling meth1 from AbstractDesignImpl");
    }
    @Override
    void abstractMethod2() {
        System.out.println("Calling meth2 from AbstractDesignImpl");

    }
}
class Interact
{ static void interactWithClient(AbstractDesign abstractDesignObj) {
             abstractDesignObj.abstractMethod();
             abstractDesignObj.abstractMethod2();
         }
}
public class AbstractProgram {
     public static void main(String...args) {
         AbstractDesign abstractDesign = new AbstractDesignImpl();
         Interact.interactWithClient(abstractDesign);
     }
}
