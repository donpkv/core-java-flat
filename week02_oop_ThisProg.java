public class ThisProg {

       String name;
       int value;

           ThisProg(String name,int value)
           {

               this.name=name;
               this.value=value;

               new ThisProg(this);

           }

        ThisProg(ThisProg thisProg)
         {

         }

           public static void main(String...args)
           {

               new ThisProg("Abhishek",100);


           }


}
