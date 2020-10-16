import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo6 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程 计算1-100的值
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int ret = 0;
                for (int i = 0; i <= 100; i++) {
                   ret += i;
                }
                return ret;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread t = new Thread(futureTask);
        t.start();
        //线程结束之后才会打印ret的值
        Integer ret = futureTask.get();
        System.out.println(ret);
    }
}
