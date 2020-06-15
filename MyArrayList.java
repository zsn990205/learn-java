import java.util.Arrays;
import java.util.Objects;
/*

泛型

 */
class Student {
    public int age;
    public String sex;
}

public class MyArrayList<E> {
    private E[] arr=(E[]) new Object[100];
    private int size;
    public void add (E o) {
        arr[size]=o;
        size++;
    }
    public E get(int index) {
        return arr[index];
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "arr=" + Arrays.toString(arr) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        MyArrayList<String> myArrayList=new MyArrayList<>();
        myArrayList.add("我");
        myArrayList.add("爱");
        myArrayList.add("中");
        myArrayList.add("国");
        System.out.println(myArrayList);
        System.out.println("-------------------------");
        MyArrayList<Student> myArrayList1=new MyArrayList<>();
        myArrayList1.add(new Student());
    }
}
