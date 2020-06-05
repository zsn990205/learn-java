 import java.util.Scanner;
  /*
 分别求二进制数字的奇数位和偶数位
 */
 public class TestDemo {
 	public static void main(String[] args) {
      int count=3;
      Scanner scan=new Scanner(System.in);
      System.out.println("请输入您的密码,您只有三次机会");
      while(count!=0) {
      	String password=scan.next();
      	if(password.equals("666666")) {
      		System.out.println("您成功了"); }
      		else {System.out.println("请重新输入");
      		     count--;
      			System.out.println("输入错误还有"+count+"机会");
      			
      		}
      	}
    }


 	public static void main3(String[] args) {
    Scanner scan=new Scanner(System.in);
    int n=scan.nextInt();
    while(n!=0) {
      System.out.print(n%10+" ");
      n= n/10;
    }
    System.out.println();
}

 	public static void main2(String[] args) {
    Scanner scan=new Scanner(System.in);
    int n=scan.nextInt();
    for(int i=1;i<=n;i++) {
    	for(int j=1;j<=i;j++) {
    		System.out.print(i+"*"+j+"="+i*j+" ");
    	}  System.out.println(" ");
    } 
}

 	public static void main1(String[] args) {
     Scanner scan=new Scanner(System.in);
     int n = scan.nextInt();
     for(int i = 31;i >=1; i-=2) {
     	System.out.print((1 & (n>>>i)));
     } System.out.println(" ");
 	    for(int i=30;i>=0;i-=2) {
       System.out.print((1 & (n>>>i)));
    }
}
}
