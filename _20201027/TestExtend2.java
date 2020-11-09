package _20201027;

class Father {
    private String name;
    private int money;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Father(String name, int money) {
        this.name = name;
        this.money = money;
    }
    public void Means() {
        System.out.println("my name is:"+name+" "+"i have:"+" "+money+"元");
    }
}
class Child extends Father{
    public Child(String name, int money) {
        super(name, money);
    }

}
public class TestExtend2 {
    public static void main(String[] args) {
        Father father = new Father("父亲",45);
        father.Means();
        Child child = new Child("儿子",20);
        child.Means();
    }
}
