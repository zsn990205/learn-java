import java.util.Arrays;

/*

考试复习

 */
public class Test {
    //二分查找
    public static int binarrySearch(int []arr,int toFind) {
        int left=0;
        int right=arr.length;
        while(left<=right) {
            int mid=(right+left)/2;
            if(arr[mid]>toFind) {
                right=mid-1;
            } else if(arr[mid]<toFind) {
                left=mid+1;
            } else {
                return mid;
            }
         } return -1;
    }

    public static void main2(String[] args) {
        int arr[]={1,5,6,8,9,25,33};
        int ret=binarrySearch(arr,25);
        System.out.println(ret);
    }
    //冒泡排序
    public static void bubbleSort(int []arr) {
    boolean flag=false;
    for(int i=0;i<arr.length;i++) {
        flag=false;
        for(int j=0;j<arr.length-i-1;j++) {
            if(arr[j]>arr[j+1]) {
                int tmp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=tmp;
                flag=true;
            }
        }
        }
    if(flag==false) {
            return;
    }
    }

    public static void main1(String[] args) {
    int arr[]=new int[]{1,5,6,4};
    bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
