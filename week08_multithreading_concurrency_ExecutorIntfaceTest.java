package concurrency;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

class ExecutorImplementer implements Executor
{

    @Override
    public void execute(Runnable command) {
        command.run();
        //runnable.run();

        System.out.println("1st approach where 1st thread called by Executor doing its task");
    }
}


class ThreadExecutorImplementer implements Executor
{

    @Override
    public void execute(Runnable command) {

         Thread thread1 = new Thread(command);
        Thread thread2 = new Thread(command);
        Thread thread3 = new Thread(command);

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("2nd approach decoupling task from 1st thread called by ThreadExecutorImplementer");
    }
}
class MyRunnable1stApproach implements Runnable
{
    @Override
    public void run() {

        System.out.println("MyRunnable 1stApproach executing!!!!");

    }
}

class MyRunnable2ndApproach implements Runnable
{
    @Override
    public void run() {

        System.out.println("MyRunnable 2ndApproach executing!!!!");

    }
}


public class ExecutorIntfaceTest {

    public static void main(String...ar)
    {

        Runnable runnable1st = new MyRunnable1stApproach(); //Create memory for thread
        Executor executor = new ExecutorImplementer();//use Executor interface framework
        executor.execute(runnable1st);

         //--------------------------tasks decoupled with 3 threads from 1st thread

        Runnable runnable2nd = new MyRunnable2ndApproach(); //Create memory for thread
        Executor executor2 = new ThreadExecutorImplementer();//use Executor interface framework
        executor2.execute(runnable2nd);
    }


}
