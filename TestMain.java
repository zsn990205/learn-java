import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int count = 0;
            String str=Integer.toBinaryString(num);
            for (int j = 0; j <str.length() ; j++) {
                if(str.charAt(j)=='0'){
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static void main8(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int count = 0;
            String str=Integer.toBinaryString(num);
            for (int j = 0; j <str.length() ; j++) {
                if(str.charAt(j)=='1'){
                    count++;
                }
            }
            System.out.println(count);
        }
        }


    public static void main7(String[] args) {
        boolean b = true;
        System.out.println(b);
    }
    public static void main6(String[] args) {
        System.out.println("\"test\"");
        char b = '\u0031';
        System.out.println(b);
    }
    public static void main5(String[] args) {
        char a1 = 'I';
        char a2 = 'L';
        char a3 = 'O';
        char a4 = 'V';
        char a5 = 'E';
        char a6 = 'U';
        System.out.print(a1);
        System.out.print(a2);
        System.out.print(a3);
        System.out.print(a4);
        System.out.print(a5);
        System.out.print(a6);
        System.out.println();
        System.out.println("=========");
        a1 = (char) (a1 + 1);
        a2 = (char) (a2 + 1);
        a3 = (char) (a3 + 1);
        a4 = (char) (a4 + 1);
        a5 = (char) (a5 + 1);
        a6 = (char) (a6 + 1);
        System.out.print(a1);
        System.out.print(a2);
        System.out.print(a3);
        System.out.print(a4);
        System.out.print(a5);
        System.out.print(a6);
    }

    public static void main4(String[] args) {
        float a = 1.02f;
        double b =1.23;

    }
    public static void main3(String[] args) {
        int a1 = 12;
        int a2 = 012;
        int a3 = 0x12;
        System.out.println(a1+" "+a2+" "+a3);
    }

    public static void main2(String[] args) {
        byte a = 2;
        byte max = Byte.MAX_VALUE;
        byte min = Byte.MIN_VALUE;
        System.out.println(a);
        System.out.println("Byte类型的最大值和最小值: "+max+" "+min);

        int c = 12345;
        short t = 12345;
        long b = 1234567800000090L;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Short.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
    }
    public static void main1(String[] args) {
        System.out.println("HelloJava");
    }
}
