

public class ThreadTest {
    private static long count = 100_0000_0000L;
    public static void main(String[] args) {
        //serial();
        concurrency();
    }

    private static void concurrency() {
        long ret = System.currentTimeMillis();
        Thread t = new Thread() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a++;
                }
            }
        };
        Thread t1 = new Thread() {
            @Override
            public void run() {
                int b = 0;
                for (long j = 0; j < count; j++) {
                    b++;
                }
            }
        };
        t.start();
        t1.start();
        //由于t和t1和main之间是并发执行的
        //调用start之后两个线程已经开始计算 此时主线程任然在执行 ret2就会被计算
        //而我们需要的是 t.t1都被计算完毕之后再进行求解ret2
        //因此我们需要这么做
        try {
        //线程等待 t和t1都执行完毕才可
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long ret2 = System.currentTimeMillis();
        long ret3 = ret2-ret;
        System.out.println(ret3);
    }

    private static void serial() {
        long ret = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a++;
        }
        int b = 0;
        for (long j = 0; j < count; j++) {
            b++;
        }
        long ret2 = System.currentTimeMillis();
        long ret3 = ret2-ret;
        System.out.println(ret3);
    }
}
