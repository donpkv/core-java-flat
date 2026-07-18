package otherpack;

import onepack.Student;

public class ChildClass extends Student {
    public static void main(String[] args) {
        ChildClass myObj = new ChildClass();
        //Student myObj = new Student();

        System.out.println("Name: " + myObj.fname + " " + myObj.lname);
        System.out.println("Email: " + myObj.email);
        System.out.println("Age: " + myObj.age);
        //System.out.println("Graduation Year: " + myObj.graduationYear);
    }
}
