package functionalinterface;

import java.util.function.Consumer;

@FunctionalInterface
interface MethodInterface
{

    void methodRef(int val);
     default int returnInt(){

        return 0;
    }
    static String returnString(){

        return "";
    }
}

public class ConsumerInterfaceExample {
    static void printMessage(String name){
        System.out.println("Hello "+name);
    }
    static int printValue(int val){
        System.out.println(val);return 0;
    }
     void methodRefrenced( int val)
     {


     }
    public static void main(String[] args) {
        // Referring method to String type Consumer interface
        /*Consumer<String> consumer = s -> { };
        consumer.accept("John");
        */

                Consumer<String> consumer1 = ConsumerInterfaceExample::printMessage;
        consumer1.accept("John");   // Calling Consumer method
        // Referring method to Integer type Consumer interface
        Consumer<Integer> consumer2 = ConsumerInterfaceExample::printValue;
        consumer2.accept(12);   // Calling Consumer method

        ConsumerInterfaceExample consumerInterfaceExample = new ConsumerInterfaceExample();

        MethodInterface methodInterface = consumerInterfaceExample::methodRefrenced;
        methodInterface.methodRef(1);
    }
}
