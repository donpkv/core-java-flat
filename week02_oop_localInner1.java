public class localInner1{
    private static int data=30;//instance variable



    void display(){
        //final int[] locdata = {30};//local variable
        //int val;
        final int[] val = {30};
        Local l=new Local("Regular Inner Class");
        l.msg();
        class Local{
            private String hello;
            int val2;
            Local(String hello)
            {
              super();
              this.hello=hello;
            }
            void msg(){
                System.out.println(hello);
                System.out.println(data);
                data=50;
                System.out.println(data);

                //locdata[0] =40;
                //System.out.println(locdata[0]);
                //val=20;
                val[0] =40;
                System.out.println(val[0]);
            }
        }

        class subLocal extends Local
        {
            subLocal()
            {
                super("");

            }

        }

        Local methLoc=new Local("Method Local Inner Class");
        methLoc.msg();
        }
   //@FunctionalInterface
        interface LocDesign
        {
            int design();
         /*   int design2(int i);
            float design3(int i);
         */
            default void fun(LocDesign locDesign)
            {

                //return 0;
            }
        }
    //static

    abstract static class absLocDesign
    {
        abstract int design();

         void fun(LocDesign locDesign)
        {

            //return 0;
        }
    }
     class Local implements LocDesign{
        private String hello;

        public int design()
        {
            return 0;
        }
        public int design2(int i) {
            return 0;
        }
         public float design3(int i) {
             return 0;
         }
        public void fun(LocDesign locDesign)
        {

        }


        Local(String hello)
        {
            super();
            this.hello=hello;
        }
        void msg(){
            System.out.println(hello);
            System.out.println(data);
            data=40;
            System.out.println(data);

        }
    }


    public static void main(String args[]){
        localInner1 obj=new localInner1();
        obj.display();
        localInner1.Local l=new localInner1().new Local("Regular Inner Class");
        l.msg();
       /* Local l=new localInner1.Local("Static Inner Class");
        l.msg();
       */

       absLocDesign absLoc = new absLocDesign(){

            @Override
            int design() {
                return 0;
            }
        };


       //l.fun(() -> 0);
        //l.fun((1)-> 0);

        //l.fun(localInner1::design);
        //l.fun(localInner1::design2);

       // int j=2;
        LocDesign locDesign = () -> 0;
        LocDesign locDesign2 = () -> 0;

        //Anonymous class
        l.fun(new LocDesign() {
            @Override
            public int design() {
                return 0;
            }

            /*@Override
            public int design2(int i) {
                return 0;
            }*/
        });
         //or lambda expression
        l.fun(() -> 0);

           }
}

