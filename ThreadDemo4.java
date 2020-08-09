

public class ThreadDemo4 {
    private static boolean isQuit = false;
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
             while (!isQuit) {
                 System.out.println("别烦我 我正追剧呢");
                 try {
                     Thread.sleep(500);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
                System.out.println("剧追完了");
            }
        };
        t.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("别追剧了 老板看着你呢");
        isQuit = true;

    }
}
