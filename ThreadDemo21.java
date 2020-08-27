import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadDemo21 {
    //这个代码和前几天的生产者和消费者哪个代码雷同
    //execute是生产者的角色
    //shutdown是消费者的角色
    //交易场所在BlockingQueue这个队列中

    static class Worker extends Thread {
    //描述当前的工作线程
    //Worker是从myThreadPoll中的BlockingQueue取任务
        private BlockingQueue<Runnable> queue = null;
    //需要能获取到任务队列的实例

        public Worker(BlockingQueue<Runnable> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                //try catch在循环之外被包裹 表示一旦收到异常 线程(run)就立即终止
                while (!Thread.currentThread().isInterrupted()) {
                //当没有线程被终止的情况下 将这个线程取出来让他去执行
                    Runnable command = queue.take();
                    //取到任务就立刻执行
                    command.run();
                }
            }  catch (InterruptedException e) {
                //线程被结束
                System.out.println("线程被结束!");
                    }
                }
            }

    static class myThreadPoll {
        //这个数据要根据实际情况来确定
        private int maxCount = 10;
        //用来组织若干个工作任务
        private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        //组织若干个工作线程
        private List<Worker> workers = new ArrayList<>();
        //接下来实现两个方法

        public void execute(Runnable command) throws InterruptedException {
        //使用延时加载的方式来创建线程
        //当池中的线程数目比较多的时候(达到设定的最大值) 就不用新建了
        //当池中的线程数目比较少的时候 就往池中新创建线程
            if (workers.size() < maxCount) {
        //新创建一个线程(工作)
              Worker worker = new Worker(queue);
              worker.start();
        //将新创建的线程加入线程队列中
              workers.add(worker);
            }

            queue.put(command);
        }

        public void shutdown() throws InterruptedException {
        //触发异常
            for (Worker worker : workers)  {
                worker.interrupt();
            }
        //还需要等待每个线程执行结束
        //不一定调用interrupt每个线程会直接结束

        //调用join()会全部结束
            for (Worker worker : workers) {
                worker.join();
            }
        }
    }
    //接下来这个方法是为了验证main函数设定的
    static class command implements Runnable {
        public int num;
        public command(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            System.out.println("正在执行线程: "+ num);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        myThreadPoll poll = new myThreadPoll();
        for (int i = 0; i < 1000; i++) {
            poll.execute(new command(i));
        }
        Thread.sleep(2000);
        poll.shutdown();
        System.out.println("线程池已经被销毁");
    }
}
