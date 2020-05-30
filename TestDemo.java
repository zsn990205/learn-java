import java.util.Scanner;
public class TestDemo {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	System.out.print("请输入一个数字"); 
     int n=scan.nextInt();
     int i;
     for(int i=2;i<n;i++) {
      if(n%i==0) {
      	System.out.print("不是"); 
      }		
		}
	if(n==i)
		System.out.print("是"); 
	}




public static void main4(String[] args) {
	Scanner scan=new Scanner(System.in);
     int n=scan.nextInt();
	if (n%100!=0 && n%4==0 || n%400==0 )
		System.out.print("今年是闰年"); 
}


public static void main3(String[] args) {
  int i=1;
  int count=0;
while(i<=100) {
	if(i%9==0) {count++;}
	i++;
}
System.out.print(count+" "); }


 	public static void main2(String[] args)  {
 		/*1!+2!+3!+4!+5!=?*/
Scanner scan=new Scanner(System.in);
     int n=scan.nextInt();
     int ret=1;
     int sum=0;
     int j=1;
     while(j<=n) { /* 因为有好多个数字相加
     	所以这些个数字(1 2 3 4 5)也得定义 这些东西在大循环里 */
     	ret=1;
     	int i=1; /*阶乘的循环(2!....)*/
     	while(i<=j) {
     		ret*=i;
     		i++;
     	}  sum+=ret;
     	j++;
     }
   System.out.println(sum);
}



/*求n的阶乘*/
	public static void main1(String[] args)  {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int i=1;
		int ret=1;
		while(i<=n) {
			ret*=i;
			i++;
		}
System.out.println(ret);
	}
}