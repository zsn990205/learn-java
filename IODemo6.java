import java.io.*;

class Student implements Serializable {
    //针对这个类进行序列化和反序列化
    public String name;
    public int age;
    public int score;
}


public class IODemo6 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
      Student s = deserializable();
        System.out.println(s.name);
        System.out.println(s.age);
        System.out.println(s.score);
    }
    public static void main1(String[] args) throws IOException {
        Student s = new Student();
        s.name = "曹操";
        s.age = 10;
        s.score = 99;
        serializable(s);

    }

    private static Student deserializable() throws IOException, ClassNotFoundException {
        //实现反序列化操作
     ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d:/student.txt"));
     Student s = (Student)objectInputStream.readObject();
     return s;
    }

    private static void serializable(Student s) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d:/student.txt"));
        //writeObject集序列化和写文件与一身
        objectOutputStream.writeObject(s);
        objectOutputStream.close();
    }

}
