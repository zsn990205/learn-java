

public class ThreadDemo17 {
    //饿汉模式
    //饿:只要类被加载 实例立刻会被创建(时机比较早)
    static class singleTon {
    //将构造方法变成私有 就无法在类外new这个实例
        private singleTon() { }

    //创建一个static成员 表示singleTon唯一实例
    //static和类相关 和实例无关 类在内存中只有一份static成员也只有一份
        private static singleTon instance = new singleTon();
    //外部获取实例
        public static singleTon getInstance() {
            return instance;
        }
    }

    public static void main(String[] args) {
        //new一个对象没报错是因为singleTon是ThreadDemo17的静态内部类
        //将static class singleTon写到ThreadDemo17外部再new对象的话就会报错
        //getInstance是获取实例的唯一方式
        singleTon s1 = singleTon.getInstance();
        singleTon s2 = singleTon.getInstance();
        singleTon s3 = singleTon.getInstance();
        System.out.println(s1==s2);
    }
}
