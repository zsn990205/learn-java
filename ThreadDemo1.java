


public class ThreadDemo1 {
    static class myThread extends Thread {
        @Override
        public void run() {
            System.out.println("这是一个线程");
        }
    }
    public static void main(String[] args) {
    //创建线程需要Thread类 来创建一个Thread实例
    //同时需要给这个线程指令 让他执行哪些代码
    //法一:直接继承Thread类 在类内重写run方法

    //[切记!] 当Thread对象被创建出来的时候 内核并没有产生一个随之的线程(PCB)
    Thread t = new myThread();
    //当 start方法调用之后才调用线程
    //此时内核中产生了一个PCB 这个PCB就会让CPU来执行线程的代码 也就是上面的run方法
    t.start();
    }
}
