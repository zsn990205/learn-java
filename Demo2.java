

class AA {
    public AA() {
        System.out.println("AA.构造");
    }
    {
        System.out.println("AA.{}");
    }
    static {
        System.out.println("AA.static");
    }
}
class BB extends AA {
    public BB() {
        System.out.println("BB.构造");
    }
    {
        System.out.println("BB.{}");
    }
    static {
        System.out.println("BB.static");
    }
}
public class Demo2 extends BB {
    public static void main(String[] args) {
        System.out.println("开始");
         new BB();
         new BB();
        System.out.println("结束");
    }
}
