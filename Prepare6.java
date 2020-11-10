package _prepareAgo;

class Calculate {
    public int num1;
    public int num2;

    public Calculate() {
        this.num1 = num1;
        this.num2 = num2;
    }
    public int add() {
        return this.num1 + this.num2;
    }
    public int mul() {
        return this.num1 * this.num2;
    }
    public double del() {
        //return (double) this.num1 / this.num2;
        return this.num1 * 1.0 / this.num2;
    }
    public int min() {
        return this.num1 - this.num2;
    }
}
class Swap {
    //private int val;
    public int val;
    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }


}
public class Prepare6 {
    //传入的参数是引用类型
    public static void swapP(Swap swap, Swap swap2) {
        int tmp = swap.val;
        swap.val = swap2.val;
        swap2.val = tmp;
    }

    public static void main(String[] args) {
        Swap s1 = new Swap();
        s1.setVal(10);
        Swap s2 = new Swap();
        s2.setVal(20);
        System.out.println("交换前"+s1.getVal()+" "+s2.getVal());
        swapP(s1,s2);
        System.out.println("交换后"+s1.getVal()+" "+s2.getVal());
    }

    //传入的参数是引用类型 就是两种不同的方法而已
    private static void swap(Swap s1, Swap s2) {
        int tmp = s1.getVal();   // tmp = s1  s1 = s2   s2 = tmp
        s1.setVal(s2.getVal());
        s2.setVal(tmp);
    }

    public static void main1(String[] args) {
        Calculate calculate = new Calculate();
        calculate.num1 = 1;
        calculate.num2 = 2;
        System.out.println(calculate.del());
    }
}
