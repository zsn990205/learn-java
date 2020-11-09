package _20201027;

class F {
    public int f;

    public F(int f) {
        this.f = f;
    }

    public void speak() {
        System.out.println("I love NBA");
    }
}
class C extends F {
    public int n;
    public C(int f) {
        super(f);
    }

    @Override
    public void speak() {
        System.out.println("I love CBA");
    }
    public void cry() {
        super.speak();
    }
}
public class TestOverride {
    public static void main(String[] args) {
         C c1 = new C(10);
         c1.speak();
         c1.cry();
    }
}
