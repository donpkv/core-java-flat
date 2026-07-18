package concurrency;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorFrameFixedThreadPool  {//SheepManager
    private int sheepCount = 0; // Should not be static
    private void incrementAndReport() {
        System.out.println("Incrementing Sheep count "+(++sheepCount));
    }
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            ExecutorFrameFixedThreadPool manager = new ExecutorFrameFixedThreadPool();
            for(int i=0; i<10; i++) {

                service.submit(() -> manager.incrementAndReport());
            }

        } finally {
            if(service != null)
            {
                service.shutdown();
                System.out.println("After shutdown");

                System.out.println("Terminating is "+service.isTerminated());

                System.out.println("Shutting down is "+service.isShutdown());
            }
        }
    }
}
