import java.util.Scanner;

public class ThreadDemo14 {
    static class Count {
     volatile public int flag = 0;
    }

    public static void main(String[] args) {
        Count count = new Count();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (count.flag == 0) {

                }
                System.out.println("线程1结束");
            }
        };

        t1.start();
        Thread t2 = new Thread() {
            @Override
            public void run() {
               Scanner scanner = new Scanner(System.in);
                System.out.println("请输入您想输入的数字");
               int n = scanner.nextInt();
               count.flag = n;
            }
        };

        t2.start();
        
    }
}
