
interface DeveloperDesign1
{    int VAL=12323456;
    //default void  module1(){}; //jdk1.8
    void  module1();
}
interface DeveloperDesign2
{
    void module2();
}
interface DeveloperDesign3 {
    void module3();
}
class DevloperImplementation implements DeveloperDesign1 ,DeveloperDesign2,DeveloperDesign3
{    //Annotation
    @Override
    public void module1() {
        //many codes to be implemented
        System.out.println("Module1");
    }
    @Override
    public void module2() {
        System.out.println("Module2");

    }
    @Override
    public void module3() {
        System.out.println("Module3");
    }
}

class Manager
{ void interactWithClient(DeveloperDesign1 devD1,DeveloperDesign2 devD2,DeveloperDesign3 devD3)
    {
        devD1.module1();
        devD2.module2();
        devD3.module3();
    }

}
public class AbstractionProgram {
    public static void main(String...args) {
        DeveloperDesign1 devD1 = new DevloperImplementation();
        DeveloperDesign2 devD2 = new DevloperImplementation();
        DeveloperDesign3 devD3 = new DevloperImplementation();

        Manager manager = new Manager();
        manager.interactWithClient(devD1,devD2,devD3);
 }
}

