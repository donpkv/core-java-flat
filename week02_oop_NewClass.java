import java.util.*;

class Student
{
       String name;
       int id;
       int marks;

        Student(String name, int id, int marks)
        {

            this.name=name;
            this.id=id;
            this.marks=marks;


        }

    public Student() {

    }

    void setValues(String name, int id, int marks)
       {
           this.name=name;
           this.id=id;
           this.marks=marks;


       }

       String getValues()
       {


           return "Name "+name+" Id "+id+" Marks "+marks;
       }

}

public class NewClass {

    public static void main(String...ar)
    {

        //HashSet hashSet = new HashSet(); can't be sorted by Collections class
        ArrayList list = new ArrayList();

        list.add("Dev");
        list.add("Mev");
        list.add("Sev");
        list.add("Aev");

        Collections.sort(list);
        String[] strings = new String[]{" "," "};
        Arrays.sort(strings);
        /*Collections.*/

        Integer i1=128;
        Integer i2=128;
        if((i1!=i2))
        System.out.println(i1+" "+i2+" are unequal");
        else
            System.out.println(i1+" "+i2+" are equal");
     /*   HashMap<ClassRoom,Integer> hashMap = new HashMap<>();

        ClassRoom student1 = new ClassRoom();
        student1.setValues("Amit",1,100);
        ClassRoom student2 = new ClassRoom();
        student2.setValues("Ram",2,80);
        ClassRoom student3 = new ClassRoom();
        student3.setValues("Shyam",3,90);
        ClassRoom student4 = new ClassRoom();
        student4.setValues("Ramesh",4,200);
        ClassRoom student5 = new ClassRoom();


        hashMap.put(student1,1000);
        hashMap.put(student2,20000);
        hashMap.put(student3,5000);
        hashMap.put(student4,7000);

        hashMap.put(student5,25000);

       System.out.print(hashMap.get(new ClassRoom("Amit",1,100)));



        Set set = hashMap.keySet();

          Iterator iterator =set.iterator();

                 while (iterator.hasNext())
                 {

                    ClassRoom student = (ClassRoom)iterator.next();

                    int fees =hashMap.get(student);

                    if(fees<10000) {
                        System.out.println("-->" + fees);
                    }

                 }

*/
    }



}
