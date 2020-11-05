package _20201102;

class Outer {
    public int i = 100;
    public void outerFunction() {
        System.out.println("outerFunction is running");
    }
    class Inner {
        public int j = 5;
        public void fun() {
            System.out.println(i+" "+j);
            outerFunction();
        }
    }
}
public class TestInner {
    public static void main(String[] args) {


    }
}
