public class Practice {
   public static void main (String[] args) {
     int n=5;
     int ret=sum(n);
     System.out.println(ret);
   }
   public static int sum(int n) {
    if(n==1) {
      return 1;
    } else {
      return n+sum(n-1);
    }
 }
}
/* public static void main1(String[] args) {
	int n=5;
	int ret=factor(5);
	 System.out.println(ret);
   }
   public static int factor1(int n) {
   	if(n==1) {
   		return 1;
   	} else {
   		return n*factor(n-1);
   	}
}
} */