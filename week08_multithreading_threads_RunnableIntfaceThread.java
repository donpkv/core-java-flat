package threads;

/*interface MyInterface
{
    int varInt=10;
    void method();


}*/
public class RunnableIntfaceThread implements  Runnable {

    public void  run()  {
    for(int i=0; i<=3; i++)
        System.out.println(Thread.currentThread().getName()+" Printing record: "+i);
}
    public static void main(String[] args) {
        /*RunnableIntfaceThread runnableIntfaceThread = new RunnableIntfaceThread();
        Thread thread = new Thread(runnableIntfaceThread);
        thread.start();
      */
        (new Thread(new RunnableIntfaceThread())).start();
    }
}

