import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadDemoReview {
     static class Worker extends Thread {
        private BlockingQueue<Runnable> queue = null;
        public Worker(BlockingQueue<Runnable> queue) {
             this.queue = queue;
             }

             @Override
             public void run() {
               try {
                   while (!Thread.currentThread().isInterrupted()) {
                       Runnable command = queue.take();
                       command.run();
                   }
               }
               catch (InterruptedException e) {
                       System.out.println("线程被结束");
               }
             }
     }
     static class myThreadPoll {
        private int maxCount = 10;
        private BlockingQueue<Runnable> queue = new LinkedBlockingQueue();
        private List<Worker> workers = new ArrayList<>();

        public void execute(Runnable command) throws InterruptedException {
           if (workers.size() < maxCount) {
             Worker worker = new Worker(queue);
             worker.start();
             workers.add(worker);
           }
           queue.put(command);
        }

        public void shutDown() throws InterruptedException {
           for (Worker worker : workers) {
                 worker.interrupt();
                }
           for (Worker worker : workers) {
                   worker.join();
           }
        }
     }
        }