

public class ThreadDemo10 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {

                }
            }
        };
        System.out.println("线程执行前的状态"+t.getState());
        t.start();
        while (t.isAlive()) {
            System.out.println("线程运行中"+t.getState());
        }
        System.out.println("线程执行后"+t.getState());
    }
}
