

public class ThreadDemo19 {
    static class BlockingQueue {
    private int[] arr = new int[1000];
    volatile private int head = 0;
    volatile private int tail = 0;
    volatile private int size = 0;

    public void put(int val) throws InterruptedException {
        //阻塞版本的入队列操作
        synchronized (this) {
            while (arr.length == size) {
                wait();
            }
            arr[tail] = val;
            tail++;
            if (tail == arr.length) {
                tail = 0;
            }
            size++;
            notifyAll();
        }
    }
    public int take() throws InterruptedException {
        //出队列操作
        int ret = -1;
        synchronized (this) {
            while (size == 0) {
                wait();
            }
             ret = arr[head];
            head++;
            if (head == arr.length) {
                head =0;
            }
            size--;
            notifyAll();

        }
        return ret;
    }
    }

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue();
        //用两个线程分别表示生产者和消费者
        //生产者创造元素
        //消费者输出元素
        //先实现消费者消费过快 预期结果:消费者消费的快会阻塞等待 等生产者生产之后才会继续消费
        Thread producer = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        blockingQueue.put(i);
                        System.out.println("生产者生产的数字是:"+ i);
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        producer.start();
        Thread customer = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        int ret = blockingQueue.take();
                        System.out.println("消费者消费的数据是 :" + ret);
                        //Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        customer.start();
    }
}
