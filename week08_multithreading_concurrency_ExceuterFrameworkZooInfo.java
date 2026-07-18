package concurrency;

import java.util.concurrent.*;
public class ExceuterFrameworkZooInfo {
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("begin");

            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Printing zoo inventory");
                }
            });

            service.execute(new Runnable() {
                                @Override
                                public void run() {
                                    for (int i = 0; i < 3; i++) System.out.println("Printing record: " + i);
                                }
                            }
            );
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Printed zoo inventory");
                }
            });         System.out.println("end");
        }
        finally {
            if(service != null) {
                System.out.println("Shutting down is "+service.isShutdown());
                System.out.println("Terminating is "+service.isTerminated());

                System.out.println("Before shutdown");
                service.shutdown();
                System.out.println("After shutdown");

                System.out.println("Terminating is "+service.isTerminated());

                System.out.println("Shutting down is "+service.isShutdown());


            }
        }
    }
}