
/*


复习map和set
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Student2 {
    public String name;
    public int age;
    public String grade;
    public String school;

    public Student2(String name, int age, String grade, String school) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}

public class Review {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("高数");
        set.add("大物");

        System.out.println(set.contains("线代"));
        for (String s:set) {
            System.out.println(s);
        }
    }
    public static void main1(String[] args) {
        Student2 s1 = new Student2("杨洋", 28, "大二", "中国人民解放军艺术学院");
        Student2 s2 = new Student2("秦霄贤", 23, "大二", "德云社天团");
        Student2 s3 = new Student2("何九华", 33, "大三", "中央戏剧学院");
        Student2 s4 = new Student2("栾云平", 33, "大四", "清华");

        Map<String,Student2> SM=new HashMap<>();

        SM.put(s1.grade,s1);
        SM.put(s2.grade,s2);
        SM.put(s3.grade,s3);
        SM.put(s4.grade,s4);

        for (Map.Entry<String,Student2> entry :SM.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

    }

}
