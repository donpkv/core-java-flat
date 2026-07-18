
class ClassObjectsVarDef { // instance scope
    int count ; // instance variables auto initialized with 0




    public static void main (String args[]){ //Stack Memory  vdp
        int value =0; //local variable needs initialization
        ClassObjectsVarDef vdp=null;

        vdp = new ClassObjectsVarDef();// new with constructor will form Heap memory
        // reference variable or instance of class or object
        float val =2.5f;
        int i =10;

        val = i;
        i = (int)val;

        vdp.displayMethod();

        ClassObjectsVarDef vdp2 = new ClassObjectsVarDef();
        vdp2.displayMethod();
        ClassObjectsVarDef vdp3 = new ClassObjectsVarDef();
        ClassObjectsVarDef vdp4 = new ClassObjectsVarDef();
        ClassObjectsVarDef vdp5 = new ClassObjectsVarDef();
        ClassObjectsVarDef vdp6 = new ClassObjectsVarDef();
        ClassObjectsVarDef vdp7 = new ClassObjectsVarDef();
        ClassObjectsVarDef vdp8 = new ClassObjectsVarDef();


    }

    void displayMethod()//camel case  instance methods
    {
        int count=0; //local variable needs initialization

        int x =10;
        int y =20;
        int z;

        if(!(x<y)|| y>x) //boolean expression with logical OR
        {
           x = x + y;   // binary + is operartor while x, y are operands
           x+=y;

           z =  x++;  //unary operator ++ operating on single operand x


            z = x<y ? x : y; // conditional or ternary operator


        }



        System.out.println(count);


    }




}

