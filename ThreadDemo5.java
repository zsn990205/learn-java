
public class ThreadDemo5 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                //是否被中断呢
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("别烦我 我正在追剧呢");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
                System.out.println("剧终于追完了");
            }
        };
        t.start();
        Thread.sleep(5000);
        System.out.println("快别追剧了 老板来了");
        //触发中断 会强制中断
        t.interrupt();
    }
}
