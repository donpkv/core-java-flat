public class StaticCheck {

    static
    {
        System.out.println("Should be loaded and executed 1st");

    }

    {
        System.out.println("Should be executed3rd");

    }

    static
    {

        System.out.println("Should be loaded and executed 2nd");

    }

    public static void main(String...args)
    {
        StaticCheck staticCheck = new StaticCheck();

        System.out.println("Should be executed 4th");
    }
}
