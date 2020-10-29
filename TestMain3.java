package _TestClassCode;

import javax.swing.*;
import java.util.Scanner;

public class TestMain3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int year = scanner.nextInt();
            boolean ret= IsYear(year);
            System.out.println(ret);
        }
    }

    private static boolean IsYear(int year) {
        if (year % 100 != 0 && year % 4 == 0 || year % 400 == 0) {
            return true;
        }
        return false;
    }

    public static void main5(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int score = scanner.nextInt();
            testFail(score);
        }
    }

    private static void testFail(int score) {
        if (score < 60) {
            System.out.println("很遗憾 您挂科");
        } else {
            System.out.println("恭喜您 及格了");
        }
    }

    public static void main4(String[] args) {
        int a,b;
        String str = JOptionPane.showInputDialog("输入变量1",0);
        a = Integer.parseInt(str);
        String str2 = JOptionPane.showInputDialog("输入运算符号","+");
        String str1 = JOptionPane.showInputDialog("输入变量2",0);
        b = Integer.parseInt(str1);
        int c = 0;
        if (str2.equals("+")) {
            c = a + b;
        }
        if (str2.equals("-")) {
            c = a - b;
        }
        if (str2.equals("*")) {
            c = a * b;
        }
        if (str2.equals("/")) {
            if (b != 0) {
                c = a / b;
            } else {
                c = 0;
            }
        }
        JOptionPane.showMessageDialog(null,c);
    }

    public static void main3(String[] args) {
        int a,b;
        String str = JOptionPane.showInputDialog("输入变量1",0);
        a = Integer.parseInt(str);
        String str1 = JOptionPane.showInputDialog("输入变量2",0);
        b = Integer.parseInt(str1);
        int c = a + b;
        JOptionPane.showMessageDialog(null,c);
    }

    public static void main2(String[] args) {
        int a,b;
        a = 100;
        b = 200;
        int c = a + b;
//        //String str = JOptionPane.showInputDialog(0,"输入消息框");
//        //int n = JOptionPane.showConfirmDialog(null,"请选择","选择",
//                "JOptionPane.YES_NO_CANCEL_OPTION");
//        JOptionPane.showMessageDialog(null,n);
    }
    public static void main1(String[] args) {
        JOptionPane.showMessageDialog(null,"Welcome to java program!");
        System.exit(0);
    }
}
