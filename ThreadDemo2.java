

public class ThreadDemo2 {
    static class myThread implements Runnable {
        @Override
        public void run() {
            System.out.println("我还是那个线程");
        }
    }

    public static void main(String[] args) {
    //5.使用lambda表达式
        Thread t = new Thread(()->
                System.out.println("我是最后一个线程"));
        t.start();
    }

    public static void main3(String[] args) {
    //4.通过匿名内部类来实现Runnable接口
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("我是线程呦");
            }
        };
        Thread t1 = new Thread(runnable);
        t1.start();

    }
    public static void main2(String[] args) {
    //3.显示创建一个类 实现Runnable接口
     Thread t = new Thread(new myThread());
     t.start();
    }

    public static void main1(String[] args) {
        //2.通过匿名内部类的方式继承Thread
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("我是一个线程");
            }
        };
        t.start();
    }
}
