 import java.util.Scanner;
 import java.util.Random;
 import java.lang.Math;
 public class TestDemo {
  public static void main(String[] args) {
          for(int i=0;i<=999999;i++) {
            int count =0; /*数字的位数*/
            int tmp=i;  /*保存i i始终是那个不变的123 tmp会为0*/
            while(tmp!=0) {
              tmp=tmp/10;  /*求数字的位数用除法*/
              count++;
            }
            tmp=i;
            int sum=0;
             while(tmp!=0) {
              sum+=Math.pow(tmp%10,count); /*
              tmp%10d的^count*/
              tmp=tmp/10;
            } if(sum==i) {
              System.out.println(sum);
             }
            }
          }  


  public static void main10(String[] args) {
     int count =0;
      for(int i=1;i<=100;i++) {
        if(i%10==9) {
          count++;
        }
        if(i/10==9) {
          count++;
        } 
      } System.out.println("9的个数是: " + count);
}

   public static void main9(String[] args) {
   Scanner scan=new Scanner(System.in);/* a=24 b=18 */
   int a=scan.nextInt(); 
   int b=scan.nextInt(); 
   int c=a%b; /* 6 */
   while(c!=0) {
    a=b; /*a=18*/
    b=c; /*b=6*/
    c=a%b;
   }  System.out.print(b);
 }


  public static void main8(String[] args) {
      Scanner scan=new Scanner(System.in);
      int n=scan.nextInt();
     for(int i=1;i<=n;i++) {
      for(int j=1;j<=i;j++) {
  System.out.print(i+"*"+j+"="+i*j+" ");
      } System.out.println(); /* 换行打印 */
   }  
     }


  public static void main7(String[] args) {
    Scanner scan=new Scanner(System.in);
    int n=scan.nextInt();
   for(int num=2;num<=n;num++) {
      int i;
      for(i=2;i<=Math.sqrt(num);i++) {
        if(num%i==0) {
          break;
        }
      } if(i>Math.sqrt(num)) {
        System.out.print(num+" ");
      }
    }
  }


 public static void main6(String[] args) {
  Scanner scan=new Scanner(System.in);
  int n=scan.nextInt();
  if (n==1 && n==0) {
    System.out.println("不是素数");/*  
            最快求素数的方法 最优解 根号求
    */ } int i;
   for(i=2;i<=Math.sqrt(n);i++) {  /*开根号*/
          if(n%i==0) {
            break;
          } 
        } if(i>Math.sqrt(n)) {
          System.out.println(n+ "是素数");
        }
        }
      

 	public static void main5(String[] args) {
   	Scanner scan=new Scanner(System.in);
    Random random=new Random();
    int rand=random.nextInt(100);
    while(true) {
      System.out.println("请输入你的数字"); 
      int n=scan.nextInt();
         if(n>rand) {
          System.out.println("猜大了"); 
        } else if(n==rand) {/* 必须是== */
          System.out.println("猜对了"); 
        } else { System.out.println("猜错了"); 
       }
   	}
}


 	public static void main4(String[] args) {
 		int flag=1;
 		double sum=0;
 		for(int i=1;i<=100;i++) {
         sum+=1.0/i*flag;
         flag=-flag;
 		}
     System.out.println(sum); 
}


 	public static void main3(String[] args) {
    Scanner scan=new Scanner(System.in);
   	int n=scan.nextInt(); 
   	int count=0;
   	  while(n!=0) {
   	  	count++;
   	  	n=n & (n-1);
   	  } 
   	  	System.out.println(count); 
     }


   public static void main2(String[] args) {
   	Scanner scan=new Scanner(System.in);
   	int n=scan.nextInt();
   	int i;
   	for(i=2;i<=n/2;i++) {
   		if(n%i==0) {
   			System.out.println("不是素数"); 
   		}
   	}		
   }


 	public static void main1(String[] args) {
 	 Scanner scan=new Scanner(System.in);
    int Oldyear=scan.nextInt();
    if(Oldyear <=18) {
    	System.out.println("是少年"); 
     } else if(Oldyear >=19 && Oldyear <=28) { 
    	System.out.println("是青年");
     } else if(Oldyear >=29 && Oldyear <=55) {
    	System.out.println("是中年");
 	 } else {
 		System.out.println("是老年");
 	}
 }
 }