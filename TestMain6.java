package _TestClassCode;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class TestMain6 {
    public static void main(String[] args) {
        Random random = new Random();
        int r = random.nextInt(10);
        int count = 0;
        while (true) {
            int n = 0;
            String str = JOptionPane.showInputDialog
                    ("请输入您的数据",0);
            if (str != null) {
                 n = Integer.parseInt(str);
            }
            count++;
            if (n == r) {
                JOptionPane.showMessageDialog
                        (null,"您使用"+count+"次猜对了");
                break;
            } else if (n > r) {
                JOptionPane.showMessageDialog
                         (null,"猜大了");
            } else {
                JOptionPane.showMessageDialog(null,"猜小了");
            }
        }
        }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int r = random.nextInt(10);
        int count = 0;
        while (true) {
            System.out.println("请输入您的数据");
            int n = scanner.nextInt();
            count++;
            if (n == r) {
                System.out.println("您使用"+count+"次猜正确了");
            } else if (n > r) {
                System.out.println("猜大了");
            } else {
                System.out.println("猜小了");
            }
        }
    }

    public static void main2(String[] args) {
        Random random = new Random();
        int r = random.nextInt(10);
        int count = 0;
        while (true) {
            int user = 0;
            String str = JOptionPane.showInputDialog("请输入您的数据",0);
            if (str != null) {
                user = Integer.parseInt(str);
            }
            count++;
            if (user > r) {
                JOptionPane.showMessageDialog(null,"您猜的数字过大请重新输入");
            } else if (user == r){
                JOptionPane.showMessageDialog(null,"恭喜您使用"+count+"次猜对了");
            } else {
                JOptionPane.showMessageDialog(null,"您猜的数字太小请重新输入");
            }
        }
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int r = random.nextInt(10);
        int count = 0;
            while (true) {
                System.out.println("请输入您的数据");
                int user = scanner.nextInt();
                count++;
                if (user > r) {
                    System.out.println("您猜的数字过大请重新输入");
                } else if (user == r){
                    System.out.println("恭喜您用了"+count+"次猜正确了");
                } else {
                    System.out.println("您猜的数字太小请重新输入");
                }

            }
        }
    }

