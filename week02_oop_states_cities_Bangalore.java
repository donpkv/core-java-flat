package states.cities;

final class MyFinalClass
{


}

public class Bangalore {

       private final int numOfPeople =10;

    protected String cityNames;


       public void display(int val)
        {
            Mangalore mangalore = new Mangalore();

            System.out.println("Display from Bangalore");
        }

      public int display(int a, float b)
    {
        Mangalore mangalore = new Mangalore();

        System.out.println("Display from Bangalore");
        return  a;
    }


}

class Mangalore extends Bangalore{

    int numOfPeople;

    public void displayFun()
    {
         new Mangalore().cityNames="banglore";
        System.out.println("Display from Mangalore");

    }
    public void display(int val)
    {
        Mangalore mangalore = new Mangalore();

        System.out.println("Display from Bangalore");
    }


    public static void main(String...args)
    {
        new Mangalore().displayFun();
        new Mangalore().display(2);

        Bangalore bangalore = new Bangalore();
        //bangalore.numOfPeople
    }

}



