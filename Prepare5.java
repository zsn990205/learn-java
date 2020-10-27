
class Person {
    //字段-->实例成员变量
    //实例成员若不初始化 值为其对应类型的0值
    private String name;
    public int age;
    //方法-->行为
    public void eat() {
        System.out.println(name+"大傻子"+"今年"+age+"岁喜欢吃烤冷面!");
    }
    public void sleep() {
        System.out.println(name+"大傻子"+"今年"+age+"岁白天喜欢睡觉!");
    }
    public static int size;
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Test {
    public int a;
    public static int count;
}

public class Prepare5 {
    public static void main4(String[] args) {
        Test test = new Test();
        test.a++;
        Test.count++;
        System.out.println(test.a);
        System.out.println(Test.count);
        System.out.println("==============");
        Test test2 = new Test();
        test2.a++;
        Test.count++;
        System.out.println(test2.a);
        System.out.println(Test.count);
    }

    public static void main3(String[] args) {
     //访问静态成员变量 类名.静态成员变量
     //访问静态成员方法 同样使用类名.方法()
        System.out.println(Person.size);
    }

    public static void main2(String[] args) {
        Person person = new Person();
        person.setName("秦霄贤");
        System.out.println(person.getName());
        person.age = 23;
        person.eat();
        person.sleep();
    }

    public static void main1(String[] args) {
        //一个类可以产生多个对象
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
        Person person5 = new Person();
    }
}
