interface Sayable{
    void say();
    default void tell(){


    }
}

public class InstanceMethodReference {

    public static void saySomething(){
        System.out.println("Hello, this is non-static method.");
    }

    void instanceMethod()
    {


    }
    public static void main(String[] args) {
        InstanceMethodReference methodReference = new InstanceMethodReference(); // Creating object
        // Referring non-static method using reference
        Sayable sayable = methodReference::instanceMethod;
        sayable.say();
        sayable.tell();
        Sayable sayable1 =InstanceMethodReference::saySomething; //methodReference::saySomething;
        // Calling interface method
        sayable1.say();
        // Referring non-static method using anonymous object
        Sayable sayable2 = InstanceMethodReference::saySomething;//new InstanceMethodReference()::saySomething;	// You can use anonymous object also
        // Calling interface method
        sayable2.say();
    }
}
