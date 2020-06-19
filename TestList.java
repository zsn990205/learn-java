import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class TestList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("红色");
        list.add("白色");
        list.add("蓝色");
        list.add("紫色");
        System.out.println(list);
        System.out.println("----------------------");
        System.out.println(list.get(0));
        list.set(0, "黑色");
        System.out.println(list);
        System.out.println("----------------------");
        //截取部分
        System.out.println(list.subList(1, 2));
        System.out.println("-----------------------");
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        System.out.println(arrayList);
        System.out.println(linkedList);


    }
}
