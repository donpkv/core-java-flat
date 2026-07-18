package concurrency;


import java.util.concurrent.*;
public class ExecutorFrameWtihSyncronize {
    private int sheepCount = 0;
    private void incrementAndReport() {
        synchronized(this) { // or this
            System.out.print((++sheepCount)+" ");
        }
    }
    public static void main(String[] args) {
        ExecutorService service = null;      try {
            service = Executors.newFixedThreadPool(10);
            ExecutorFrameWtihSyncronize manager = new ExecutorFrameWtihSyncronize();
            for(int i=0; i<10; i++)
                service.submit(() -> manager.incrementAndReport());
        }
        finally {
            if(service != null) {
                service.shutdown();
                System.out.println("After shutdown");

                System.out.println("Terminating is "+service.isTerminated());
                System.out.println("Shutting down is "+service.isShutdown());
                System.out.println("Terminating is "+service.isTerminated());


            }
            }
    }
}


