
class A {
    public int num = 0;
}

class B {
    public int count = 0;
    public A a;
}
public class Demo1 {
    public static void main(String[] args) {
        B b = new B();
        b.count = 10;
        b.a = new A();
        b.a.num = 100;

        //针对b对象进行拷贝
        //copy1直接返回b b和b2指向同一个对象
        //B b2 = copy1(b);

        //b2指向了新的指向 发生深拷贝
        B b2 = copy2(b);

        B b3 = copy3(b);
    }

    private static B copy3(B b) {
        B ret = new B();
        ret.count = b.count;
        ret.a = new A();
        ret.a.num = b.a.num;
        return ret;
    }

    private static B copy2(B b) {
        B ret = new B();
        ret.count = b.count;
        ret.a = b.a;
        return ret;
    }

    private static B copy1(B b) {
        return b;
    }
}
