import java.util.Scanner;

public class ThreadDemo13 {
    public static void main(String[] args) {
        Object locker = new Object();
        Object locker2 = new Object();
        Thread t1 = new Thread() {
            @Override
            public void run() {
           Scanner scanner = new Scanner(System.in);
           synchronized (locker.getClass()) {
            System.out.println("请输入一个整数");
            //用户不输入就会一直阻塞
               int n = scanner.nextInt();
               System.out.println("n=" + n);
           }
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
            while (true) {
               synchronized (locker2.getClass()) {
                   System.out.println("线程2拿到锁了");
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
                }
            }
        };
        t2.start();
    }
}
