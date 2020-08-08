

public class ThreadDemo3 {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread("我是最初的线程") {
            @Override
            public void run() {
               for (int i = 0; i < 10; i++) {
                   System.out.println(Thread.currentThread().getName());
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
               //run方法的执行过程代表内线程的生命周期
                System.out.println("线程要退出了");
            }
        };
        //这一组属性是不变的 一旦线程被创建就不变了
        System.out.println(t.getName());
        System.out.println(t.getId());
        System.out.println(t.getPriority());
        System.out.println(t.isDaemon());
        //这一组数据随着线程的运行过程会发生改变
        System.out.println(t.isAlive());
        System.out.println(t.isInterrupted());
        System.out.println(t.getState());
        System.out.println("===================================");

       t.start();
        while (t.isAlive()) {
            System.out.println(t.isAlive());
            System.out.println(t.isInterrupted());
            System.out.println(t.getState());
            Thread.sleep(300);
        }
    }
}
