import java.io.*;

public class IODemo5 {
    public static void main(String[] args) {
        copyFile();
    }
    private static void copyFile3() {
        //带缓冲区的字符流中有一种特殊的用法 按行读取
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\test"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\test"))) {
            String buffer = " ";
            //readline表示读取一行 直到读取到换行符为止 读取完毕返回null
            while ((buffer = bufferedReader.readLine()) != null) {
                bufferedWriter.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void copyFile2() {
        //带缓冲区的字符流
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\test"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\test"))) {
            char[] buffer = new char[1024];
            int len = -1;
            while ((len = bufferedReader.read(buffer)) != -1) {
              bufferedWriter.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void copyFile() {
        //拷贝字符流
        try (FileReader fileReader = new FileReader("D:\\test");
             FileWriter fileWriter = new FileWriter("D:\\test")) {
            char[] buffer = new char[1024];
            int len = -1;
            while ((len = fileReader.read(buffer)) != -1) {
                fileWriter.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
