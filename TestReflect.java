import java.lang.reflect.Field;
import java.util.Scanner;

/*
反射

 */
class Dog {
    public String name;
    public void eat(String food) {
        System.out.print(name+"正在吃"+food);
    }

    public Dog(String name) {
        this.name = name;
    }
    public Dog() {
        this.name = "也行";
    }
}
public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
    //通过发射获取/修改属性
        Class dogClass = Class.forName("Dog");
    //通过getDeclaredField得到局部信息 通过field表示
        Field field = dogClass.getDeclaredField("name");
    //加上这行才能查看private成员
        field.setAccessible(true);
        Dog dog = new Dog();
        field.set(dog,"咯咯哒");
        String name = (String) field.get(dog);//相当于 dog.name操作
        System.out.println(name);
    }

    public static void main2(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    //通过类对象创建实例
    //以下代码运行时会出现异常 Dog没提供无参数的构造方法 直接实例化就会报错
        Class dogClass = Class.forName("Dog");
        Dog dog = (Dog)dogClass.newInstance();
        dog.eat("狗粮");
    }
    public static void main1(String[] args) throws ClassNotFoundException {
    //获取类对象 三种方法
    //1.通过全限顶类名获取 全限定=包名+类名
        Class dogClass = Class.forName("Dog");
    //2.通过类的实例来获取
        Dog dog = new Dog("也行");
        Class dogClass2 = dog.getClass();
    //3.通过类直接获取
        Class dogClass3 = Dog.class;
        System.out.println(dogClass3 == dogClass2);
        System.out.println(dogClass == dogClass3);
    }
}
