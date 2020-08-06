

public class TestDemo12 {
    static class Test {
        private Object o = new Object();
        public void method() {
            synchronized (o) {
                System.out.println("我是一把锁");
            }
        }
    }
    public static void main(String[] args) {
     Test t = new Test();
     t.method();
    }
}
