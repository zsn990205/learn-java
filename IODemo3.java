import java.io.*;

public class IODemo3 {
    public static void main(String[] args) throws IOException {
      copyFile();
    }
    private static void copyFile2() {
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("D:\\test"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("D:\\test2"))) {
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void copyFile() throws IOException {
       // 需要创建的实例是BufferInputStream；BufferOutputStream:
       // 要创建这样的实例首先要创建FileInputStream和FileOutputStream
        FileInputStream fileInputStream = new FileInputStream("D:\\test");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\test2");
        //方法内部持有了缓冲区对象
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        //这是用户指定的缓冲区
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = bufferedInputStream.read(buffer)) != -1) {
            bufferedOutputStream.write(buffer,0,len);
        }
        //此处涉及了四个流对象
        //调用这一组close时就会自动关闭FileInputStream和FileOutputStream
        //此时就不需要四次关闭
        bufferedInputStream.close();
        bufferedOutputStream.close();

    }
}
