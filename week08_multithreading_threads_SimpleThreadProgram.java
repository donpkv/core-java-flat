package threads;

class ThreadA extends Thread
{

     public void run()
     {
         new ResourceClass().resource(this);

     }

}

class ThreadB extends Thread
{

    public void run()
    {
        new ResourceClass().resource(this);



    }

}

class ThreadC extends Thread
{

    public void run()
    {
        new ResourceClass().resource(this);



    }

}

class ResourceClass {

    //synchronized
    synchronized void resource(Thread thread)
     {

           for (int i =1 ; i<=20 ;i++)
           {
               System.out.println(  thread.getName()+" printing "+i);

/*               try {
                   Thread.sleep(2000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }*/
           }

     }


}

public class SimpleThreadProgram {

    public static void main(String...args)
    {
        ThreadA threadA = new ThreadA(); // Thread is born or enters into new state
        ThreadB threadB = new ThreadB();
        ThreadC threadC = new ThreadC();

/*
        threadA.setName("Thread A");   //start();
        threadB.setName("Thread B");
        threadC.setName("Thread C");
*/

         threadA.start();   //start() makes these threads runnable or ready to run
        threadB.start();
        threadC.start();
        /*threadA.run();   //start() makes these threads runnable or ready to run
        threadB.run();
        threadC.run();
  */    }

}
