class Bob {//extends Object
       String name;

       Bob(String name)
       {
           this.name =name;

       }

      public String toString()
      {
          return name;
      }

}
class John
{
    String name;

    John(String name)
    {
        this.name =name;

    }

    public String toString()
    {
        return name;
    }


}
public class HardToRead {
    public static void main(String...args) {
        Bob bob1 = new Bob("My name is Bob1");
        Bob bob2 = new Bob("My name is Bob2");
        System.out.println(" "+bob1);//.toString()
        System.out.println(" "+bob2);//.toString()

        John john = new John("My Name is John");
        System.out.println(" "+john);


    }


}
