import javax.swing.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TestMain2 {
    public static void main(String[] args) {
        //JOP
        int a,b,c;
        String str = JOptionPane.showInputDialog("输入变量1",0);
        a = Integer.parseInt(str);
        String str2 = JOptionPane.showInputDialog("输入变量2",0);
        b = Integer.parseInt(str2);
        String str3 = JOptionPane.showInputDialog("输入变量3",0);
        c = Integer.parseInt(str3);
        System.out.println(compareMax(a,b,c));
        System.out.println(compareMin(a,b,c));
        System.out.println(averNum(a,b,c));
        paiXu(a,b,c);
    }

    public static void main7(String[] args) throws IOException {
        System.out.println("请输入三个数：");
        int a = System.in.read();
        int b = System.in.read();
        int c = System.in.read();
//        int max = compareMax(a,b,c);
//        int min = compareMin(a,b,c);
//        double ave = averNum(a,b,c);
        System.out.println("最大值为：" + (compareMax(a,b,c)-48));
        System.out.println("最小值为：" + (compareMin(a,b,c)-48));
        System.out.println("平均值为：" + (averNum(a,b,c)-48));
        paiXu(a,b,c);
    }
    public static void main6(String[] args) {
        //人机交互问题
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入第"+(i+1)+"个数：");
            arr[i] = sc.nextInt();
        }
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
             a = arr[0];
             b = arr[1];
             c = arr[2];
        }
        System.out.println(compareMax(a,b,c));
        System.out.println(compareMin(a,b,c));
        System.out.println(averNum(a,b,c));
        paiXu(a,b,c);
    }

    private static int countSum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    public static void main5(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            //在这里输出相当重要 没这个输出程序无法进行求和
            //相当于下面输入一个上面输出一个
            //System.out.println("请输入第"+i+"个值");
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("和为：" + sum);
    }


    public static void main4(String[] args) {
//        double x = 0 ,y = 0;
//        DataInputStream d = new DataInputStream(System.in);
//        System.out.println("输入x的值");
//        try {
//            x = Double.parseDouble(d.readLine());
//            System.out.println("输入y的值");
//            y = Double.parseDouble(d.readLine());
//            double ret = x + y;
//            System.out.println("x的值:" +x +": y的值:"+y);
//            System.out.println("和是: "+ ret);
//        } catch (IOException e) {
//            System.out.println("wrong!!!");
//        }

    }
    public static void main3(String[] args) {
        byte[] b = new byte[5];
        try {
            int len = System.in.read(b);
            System.out.println("读取字节数: "+len);
            for (int i = 0; i < len; i++) {
                System.out.print(b[i]+"\t");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main2(String[] args) {
        System.out.println("请输入: ");
        int i = 0;
        while (true) {
            try {
                i = System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(i);
            }
        }
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            System.out.println(compareMax(a,b,c));
            System.out.println(compareMin(a,b,c));
            System.out.println(averNum(a,b,c));
            paiXu(a,b,c);
        }
    }

    private static void paiXu(int a, int b, int c) {
        int[] arr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            arr[0] = a;
            arr[1] = b;
            arr[2] = c;
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static double averNum(int a, int b, int c) {
        double sum = a + b + c;
        double ret = sum / 3;
        return ret;
    }

    private static int compareMin(int a, int b, int c) {
        int min = a;
        if (b < a) {
            min = b;
        }
        int ret = min < c ? min : c;
        return ret;
    }

    private static int compareMax(int a, int b, int c) {
         int max = a;
         if (b > a) {
             max = b;
         }
         int ret = max > c ? max : c;
         return ret;
    }
}
