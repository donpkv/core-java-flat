
/*class RunnableImpl implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 3; i++) {

            System.out.println("Run by " + Thread.currentThread().getName() + " i is " + i);

        }
    }
}*/

interface Design
{

      void fun();

}
public class ThreadDemoWtihLambda {

    public static void main(String...ar)
    {

        Design design = () -> System.out.println("Helloo"); // Lambda Expression
        //Runnable nr= new RunnableImpl();
        /*Design design = new Design(){ //                     Or Anonymous Class
            public void fun(){

        }};*/

        design.fun();

        Runnable nr=()->{
            for(int i=0;;i++)//i<=3
            {

                System.out.println("Run by "+Thread.currentThread().getName()+" i is "+i);
                try {
                    Thread.currentThread().join(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread one = new Thread(nr);
        Thread two = new Thread(nr);
        Thread three = new Thread(nr);
        Thread four = new Thread(nr);
        Thread five = new Thread(nr);
        Thread six = new Thread(nr);


        one.setPriority(Thread.NORM_PRIORITY);
        two.setPriority(Thread.NORM_PRIORITY);
        three.setPriority(Thread.NORM_PRIORITY);
        four.setPriority(Thread.NORM_PRIORITY);
        five.setPriority(Thread.NORM_PRIORITY);
        six.setPriority(Thread.NORM_PRIORITY);

        /*
        one.setName("Fred");;
        two.setName("Lucy");
        three.setName("Ricky");
*/
        one.start();;
        two.start();
        three.start();
        four.start();;
        five.start();
        six.start();


    }
}
