
 class AnimalClass {
    private String species;
    private boolean canHop;
    private boolean canSwim;
    public AnimalClass(String speciesName, boolean hopper, boolean swimmer) {
        species = speciesName;      canHop = hopper;      canSwim = swimmer;
    }
    public boolean canHop() {
        return canHop;
    }
    public boolean canSwim() {
        return canSwim;
    }
    public String toString() {
        return species; }
}

 @FunctionalInterface
 interface CheckTrait {
    public boolean test(AnimalClass a);
   // public boolean method(AnimalClass a);

}


 public class LambdaExpressionTest {
    private static void print(AnimalClass animal, CheckTrait trait) {
        if(trait.test(animal))
            System.out.println(animal);
    }
     public static void main(String[] args) {
        print(new AnimalClass("fish", false, true), a -> a.canHop());
        print(new AnimalClass("kangaroo", true, false), a -> a.canHop());

         CheckTrait checkTrait = a -> {

             int num = 10;
             System.out.println("Num is " + num);
             System.out.println("This is 2nd line");

             return a.canHop();
         };

         checkTrait.test(new AnimalClass("fish", false, true));
    }
}