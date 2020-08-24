

public class ThreadDemo18 {
    //使用懒汉模式(比饿汉模式效率更高)
    //因为实例化不一定会用的到
    static class singleTon {
    private singleTon() {}
    //类被创建后不会立刻实例化
    volatile private static singleTon instance = null;
    //第一次获取实例的时候再实例化
    public static singleTon  getInstance() {
        //延时加载 要是一直没有调用getInstance 实例化过程就被省略
        if (instance == null) {
            synchronized (singleTon.class) {
                if (instance == null) {
                    instance = new singleTon();
                }
            }
        } return instance;
    }
        }
}
