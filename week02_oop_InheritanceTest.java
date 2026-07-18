//import java.lang.*;

abstract class GrandParent //extends Object Multilevel Inheritense
{  //private


    GrandParent() {
        super();
        System.out.println("Calling GrandParent!!!");
        //GrandParent grandParent = new GrandParent();

    }


}
class ParentClass extends GrandParent
{

    ParentClass()
    {
        //super();
        System.out.println("Calling ParentClass!!!");
    }
}
class ChildClass extends ParentClass //,GrandParent //Multiple inheritence not supported in java
{
    ChildClass() {
        //super();
        System.out.println("Calling ChildClass!!!");
    }
}

class GrandChild extends ChildClass
{
    GrandChild() {
        //super();
        System.out.println("Calling GrandChild!!!");

    }
}
public class InheritanceTest {
    public static void main(String...args) {

        GrandChild grandChild = new GrandChild();
    }

}



