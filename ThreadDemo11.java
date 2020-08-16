

public class ThreadDemo11 {
    static class Count{
    public static int count = 0;

   synchronized public void increase() {
        count++;
    }
}
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        Thread t = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    count.increase();
                }
            }
        };
        t.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    count.increase();
                }
            }
        };
        t2.start();

        t.join();
        t2.join();
        System.out.println(Count.count);
    }
}
