

/*

Map

 */

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        System.out.println(map.isEmpty());
        System.out.println(map.size());
        //插入键值对
        map.put("秦凯旋","秦霄贤");
        map.put("何健","何九华");
        map.put("尚文博","尚九熙");
        map.put("孟xx","孟鹤堂");
        map.put("孙树超","孙九芳");
        System.out.println("--------------------------");
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        //获取键值对
        System.out.println("--------------------------");
        System.out.println(map.get("秦霄贤"));
        //contains
        System.out.println("--------------------------");
        System.out.println(map.containsKey("孙树超"));
        System.out.println(map.containsValue("孟鹤堂"));//比较低效
        //添加键值对
        System.out.println("--------------------------");
        System.out.println(map.getOrDefault("周九良","周旋"));
        System.out.println("--------------------------");
        //循环遍历
        for (Map.Entry<String,String> entry:map.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        //删除键值对
        System.out.println("--------------------------");
        System.out.println(map.remove("孟鹤堂"));
        //清空键值对
        System.out.println("---------------------------");
        map.clear();
        System.out.println(map.size());
        System.out.println(map.isEmpty());

    }
}