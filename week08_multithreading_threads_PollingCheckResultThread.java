package threads;

public class PollingCheckResultThread {
    private static int counter = 0;
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                System.out.println(PollingCheckResultThread.counter++);

            }
        }).start();


        while(PollingCheckResultThread.counter<100) {
            System.out.println("Not reached yet");
            try {
                Thread.sleep(3000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Reached!");
    }

}