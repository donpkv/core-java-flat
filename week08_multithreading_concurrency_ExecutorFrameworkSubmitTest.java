package concurrency;

import java.util.concurrent.*;
public class ExecutorFrameworkSubmitTest {
    private static int counter = 0;
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<?> result = service.submit(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 500; i++) ExecutorFrameworkSubmitTest.counter++;
                }
            });

            result.get(10, TimeUnit.SECONDS);
            System.out.println("Reached!");
        }
        catch (TimeoutException e) {
            System.out.println("Not reached in time");
        } finally {
            if(service != null) {
                service.shutdown();
                System.out.println("After shutdown");

                System.out.println("Terminating is "+service.isTerminated());

                System.out.println("Shutting down is "+service.isShutdown());

            }
        }
    }
}

