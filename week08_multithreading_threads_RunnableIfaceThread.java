package threads;

/*class RunThread implements Runnable
{
    @Override
    public void run() {
        for (int i=0 ;i<20;i++)
        {
            System.out.println("i --> "+i);
        } }
}*/
public class RunnableIfaceThread {
    public static void main(String...args) {
       /* Runnable runThread = new RunThread();
        runThread.run(); //Synchronous way of calling a thread

        Thread threadRunThred = new Thread(runThread);
        threadRunThred.start();
*/


        //A a1 = new A();
/*        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("i --> " + i);
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        */


        /*Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("i --> " + i);
                }
            }
        });
        thread.start();
        */

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("i --> " + i);
            }
        });

        thread.start();


        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("i --> " + i);
            }
        });
        thread1.start();

    }

}
