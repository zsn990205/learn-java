import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IODemo4 {
    //使用缓冲区和不适用缓冲区分别来感受效率
    public static void main(String[] args) throws FileNotFoundException {
    noBuffer();
    //haveBuffer();
    }

    private static void haveBuffer() {
        long begin = System.currentTimeMillis();
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("D:\\test"))) {
            int ch = -1;
            while ((ch = bufferedInputStream.read())!= -1) {

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("havebuffer"+(end-begin)+"ms");
    }

    private static void noBuffer()  {
        //一个字节一个字节的读
        long begin = System.currentTimeMillis();
        try (FileInputStream fileInputStream = new FileInputStream("D:/testC:/Users/77467.android");) {
            int ch = -1;
            while ((ch = fileInputStream.read()) != -1) {
                //不干事
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("nobuffer"+(end-begin)+"ms");
    }
}
