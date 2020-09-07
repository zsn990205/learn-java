
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double money = scanner.nextDouble();
            System.out.println(solution(money));
        }
    }

    private static String solution(double money) {
        StringBuilder sb = new StringBuilder();
        sb.append("人民币");
        String str = String.valueOf(money);
        //壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、
        return sb.toString();
    }

    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int learn = scanner.nextInt();
            //相应课程的学分 用空格分开
            int[] score = new int[learn];
            for (int i = 0; i < learn; i++) {
                score[i] = scanner.nextInt();
            }
            //对应的课程得分
            int[] grade = new int[learn];
            for (int i = 0; i < learn; i++) {
                grade[i] = scanner.nextInt();
            }
            double ret = calculate(score,grade);
            System.out.printf("%.2f",ret);
        }
    }

    private static double calculate(int[] score, int[] grade) {
        //一门课程的学分绩点=该课绩点*该课学分
        //2．总评绩点=所有学科绩点之和/所有课程学分之和
        //课程的学分和
        double sum = 0.0;
        //课程的学科绩点之和
        double point = 0.0;
        for (int i = 0; i < grade.length; i++) {
            sum += score[i]; //学分和
            point += score[i]*GPA(grade[i]);
        }
        return point/sum;
    }

    private static double GPA(int score) {
        double gpa = 0.0;
        //成绩-绩点
        //90——100 4.0 85——89 3.7 82——84 3.3 78——81 3.0
        //75——77  2.7 72——74 2.3 68——71 2.0 64——67 1.5
        //60——63 1.0 60以下 0
        if (score >= 90 && score <= 100) {
            gpa = 4.0;
        } else if (score >= 85 && score <= 89) {
            gpa = 3.7;
        } else if (score >= 82 && score <= 84) {
            gpa = 3.3;
        } else if (score >= 78 && score <= 81) {
            gpa = 3.0;
        } else if (score >= 75 && score <= 77) {
            gpa = 2.7;
        } else if (score >= 72 && score <= 74) {
            gpa = 2.3;
        } else if (score >= 68 && score <= 71) {
            gpa = 2.0;
        } else if (score >= 64 && score <= 67) {
            gpa = 1.5;
        } else if (score >= 60 && score <= 63) {
            gpa = 1.0;
        } else {
            gpa = 0.0;
        }
        return gpa;
    }

    public static void main3(String[] args) {
        //没写完
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
         //第一行:输入学生的数目和操作的数目
            int student = scanner.nextInt();
            int operations = scanner.nextInt();
          //第二行:学生的初始成绩
          int[] arr = new int[student];
          for (int i = 0; i < student; i++) {
             arr[i] = scanner.nextInt();
          }
          //对于字母为"Q"的操作 只需要找出最大值
            for (int i = 0; i < student; i++) {
                String c = scanner.next();
                int max = 0;
                int A = scanner.nextInt();
                int B = scanner.nextInt();
                if (c.equals("Q")) {
                    for (int j = B-1; j < A; j++) {
                        max = max > arr[j] ? max:arr[j];
                    }
                    System.out.println(max);
                }

            }

        }
    }
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
          //怪物的数量
            int n = scanner.nextInt();
          //小易的初始能力值
            int start = scanner.nextInt();
          //怪物的防御值
            int[] monster = new int[n];
            for (int i = 0; i < n; i++) {
                monster[i] = scanner.nextInt();
            }
            for (int i = 0; i < monster.length; i++) {
                if (start >= monster[i]) {
           //如果小易的初始值大于怪兽 他一定打得过
                    start += monster[i];
                } else {
           //此时怪兽的防御值一定大
                    start += getEnergy(start,monster[i]);
                }
            }
            System.out.println(start);
        }
    }

    private static int getEnergy(int start, int i) {
        //使用最大公因数的形式
        //辗转相除法
        if (i % start == 0) {
            return start;
        }
        int tmp = i % start;
        while (tmp != 0) {
            i = start;
            start = tmp;
            tmp = i % start;
        }
        return start;
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            int flg = 1; //×(-1)的
            int sum1 = 0; //被5整除
            int sum2 = 0; //余1的
            int sum3 = 0; //余2的
            int sum4 = 0; //余3的
            int sum5 = 0; //余4的
            int count = 0; //记A3的
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                //先将数组中所有的数字对5求模
                if (arr[i] % 5 == 0) {
                    if (arr[i] % 2 == 0) {
                        sum1 += arr[i];
                    }
                }
                  if (arr[i] % 5 == 1) {
                      sum2 += arr[i]*flg;
                      flg = -flg;
                }
                  if (arr[i] % 5 == 2) {
                      sum3++;
                  }
                  if (arr[i] % 5 == 3) {
                      sum4 += arr[i];
                      count ++;
                  }
                  if (arr[i] % 5 == 4) {
                      if (arr[i] > sum5) {
                          sum5 = arr[i];
                      }
                  }
            }
            if (sum1 != 0) {
                System.out.print(sum1+" ");
            } else {
                System.out.print("N"+" ");
            }
            if (sum2 != 0) {
                System.out.print(sum2+" ");
            } else {
                System.out.print("N"+" ");
            }
            if (sum3 != 0) {
                System.out.print(sum3+" ");
            } else {
                System.out.print("N"+" ");
            }
            if (sum4 != 0) {
                //求小数位数的这个方法需要记住!
                System.out.print(sum4/count+"."+(int)((sum4%count*100/count+5)/10)+" ");
            } else {
                System.out.print("N"+" ");
            }
            if (sum5 != 0) {
                System.out.print(sum5+" ");
            } else {
                System.out.print("N"+" ");
            }
        }
    }
}
