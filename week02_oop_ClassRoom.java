public class ClassRoom {

      static int studentCount ;

             ClassRoom()
             {
                 studentCount++;
                 System.out.println("Student count "+studentCount);
             }



             public static void main(String...args)
             {
                 ClassRoom student1 = new ClassRoom();
                 ClassRoom student2 = new ClassRoom();
                 ClassRoom student3 = new ClassRoom();
                 ClassRoom student4 = new ClassRoom();
                 ClassRoom student5 = new ClassRoom();



             }
}
