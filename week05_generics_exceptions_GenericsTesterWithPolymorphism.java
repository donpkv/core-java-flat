import java.util.ArrayList;
import java.util.List;
public class GenericsTesterWithPolymorphism<A,H> {
    //Upper bound wildcard
    //in category
    A a;
    H h;
    public void add(A t) {
        this.a = t;
    }
    public A get() {
        return a;
    }
    //Upper bound wildcard
    public static void deleteCat(List<? extends Cat> catList, Cat cat) {
        catList.remove(cat);
        System.out.println("Cat Removed");
    }
    //Lower bound wildcard
    //out category
    public static void addCat(List<? super RedCat> catList) { //List<Animal super Cat>
        catList.add(new RedCat("Red Cat"));
        System.out.println("Red Cat Added");
    }
    //Unbounded wildcard
    //Using Object method toString()
    public static void printAll(List<?> list) {
        for (Object item : list)
            System.out.println(item + " ");
    }
    public static void main(String[] args) {
        List<Animal> animalList= new ArrayList<Animal>();
        List<Cat> catList= new ArrayList<Cat>();
        List<RedCat> redCatList= new ArrayList<RedCat>();
        //add list of super class AnimalClass of Cat class
        System.out.println("This Programs adds Plymorphic aguments to Collection List");
        System.out.println("---------------------------------------------------------");
        System.out.println("Passing animalList object of Animal class to addCat Function");
        System.out.println("Going to Add Red Cat to Animal because RedCat extends Cat and Cat extends Animal");
        addCat(animalList); // Plymorphic aguments
        //add list of Cat class
        System.out.println("Going to Add Red Cat to Cat because RedCat can be added to Cat it extends from");
        addCat(catList);
        System.out.println("Going to Add Red Cat to Sametype");
        addCat(redCatList);
        addCat(redCatList);
        GenericsTesterWithPolymorphism<Integer,String> genericsTester = new GenericsTesterWithPolymorphism<Integer,String>();
        //print all animals
        printAll(animalList);
        printAll(redCatList);
        Cat cat = redCatList.get(0);
        //delete cat
        deleteCat(redCatList, cat);
        //deleteCat(animalList, cat);
        printAll(redCatList);
    }
}
class Animal {// Polymorphism
    String name;
    Animal(String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}
class Cat extends Animal {   // 1 Form of Super class Animal
    Cat(String name) {
        super(name);
    }
}
class RedCat extends Cat { //2nd Form of Super class Animal
    RedCat(String name) {
        super(name);
    }
}
class Dog extends Animal {
    Dog(String name) {
        super(name);
    }
}