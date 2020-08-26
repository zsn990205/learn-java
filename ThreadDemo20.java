import java.util.concurrent.PriorityBlockingQueue;

public class ThreadDemo20 {
    //传入比较器 来找优先级高的
    static class Task implements Comparable<Task> {
        //runnable中的run方法来描述具体的任务
        private Runnable command;
        private long time;
        public Task(Runnable command,long after) {
            this.command = command;
            this.time = after+System.currentTimeMillis();
        }
        public void run() {
            command.run();
        }

        @Override
        public int compareTo(Task o) {
            return (int) (this.time-o.time);
        }
    }
    static class Worker extends Thread {
        private PriorityBlockingQueue<Task> queue = null;
        private Object o = null;
        public Worker(PriorityBlockingQueue<Task> queue,Object o) {
            this.queue = queue;
            this.o = o;
        }

        @Override
        public void run() {
        //实现线程具体循环的内容
        //先取出队首元素 检查时间是否到了
        while (true) {
            try {
                Task task = queue.take();
                long curTime = System.currentTimeMillis();
                if (task.time > curTime) {
                    //时间未到 将任务塞进队列
                  queue.put(task);
                  synchronized (o) {
                      o.wait(task.time-curTime);
                  }
                } else {
                    task.run();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
              //出现线程异常得正确退出
                break;
            }
        }
        }
    }
    static class Timer {
        //为了避免忙等 使用wait(time)方法
        //使用this也行
        private Object o = new Object();
        //1.用一个类来描述任务

        //2.使用阻塞优先队列来组织若干个任务 队首元素必须是最先执行的任务
        private PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();

        //3.用一个线程循环扫描阻塞队列的队首元素 如果时间到 就执行
        public Timer() {
            //创建线程
            Worker worker = new Worker(queue,o);
            //启动线程
            worker.start();
        }

        //4.还需要一个方法 让调用者将任务安排进来
        public void schedule(Runnable command, long after) {
            Task task = new Task(command, after);
            queue.put(task);
            synchronized (o) {
                o.notify();
            }
        }
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hehe");
                timer.schedule(this,2000);
            }
        },(2000));
    }
}
