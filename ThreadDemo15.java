

public class ThreadDemo15 {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        synchronized (o) {
            System.out.println("等待前");
            o.wait();
            System.out.println("等待后");
        }

    }
}
