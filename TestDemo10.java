

/*

collection

 */


import java.util.ArrayList;
import java.util.Collection;


public class TestDemo {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        //判断大小和是否为空
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());
        System.out.println("--------------------------");
        //增
        collection.add("我");
        collection.add("是");
        collection.add("中");
        collection.add("国");
        collection.add("人");
        System.out.println(collection);
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());
        System.out.println("---------------------------");
        //循环遍历
        for (String s :collection) {
            System.out.println(s);
        }
        //contains
        System.out.println("----------------------------");
      boolean s=collection.contains("中");
        System.out.println(s);
        //删除
        collection.remove("我");
        for (String o:collection) {
            System.out.println(o);
        }
         //清空
        System.out.println("---------------------------");
       collection.clear();
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());

    }
}
