
/*


复习代码
 */


import java.util.Arrays;
import java.util.Stack;

public class Test {
    public static void insertSort(int []arr) {
        //插入排序
        //还需再看
       for (int bound = 0; bound < arr.length; bound++) {
           int tmp = arr[bound];
           int cur = bound-1;
           for (; cur >= 0; cur--) {
               if (arr[cur] > tmp) {
                   arr[cur+1] = arr[cur];
               } else {
                   break;
               }
           }
           arr[cur+1] = tmp;
       }
    }
    public static void shellSort(int []arr) {
        //希尔排序
     int gap=arr.length/2;
     while(gap>1) {
         gap/=2;
         insertSortGap(arr,gap);
     }
         insertSortGap(arr,1);
    }

    private static void insertSortGap(int[] arr, int gap) {
    for(int bound=1;bound<arr.length;bound++) {
        int tmp=arr[bound];
        int cur=bound-gap;
        for(;cur>=0;cur-=gap) {
            if(arr[cur]>tmp) {
                arr[cur+gap]=arr[cur];
            }
            else {
                break;
            }
        }  arr[cur+gap]=tmp;
    }
    }

    public static void selectSort(int []arr) {
        //选择排序(选择排序是在每组中选取最小值的操作)
       for (int bound = 0; bound < arr.length; bound++) {
           for (int cur = bound; cur < arr.length; cur++) {
               if (arr[cur] < arr[bound]) {
                   swap(arr,cur,bound);
               }
           }
       }

    }

    private static void swap(int[] arr, int i, int j) {
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }

    public static void heapSort(int []arr) {
        //堆排序 1.先创建一个大堆
        //2.交换堆顶元素和堆底元素并删除堆底元素
        //3.继续进行向下调整
       createHeap(arr);
       int heapSize = arr.length;
       for (int i = 0; i < arr.length-1; i++) {
           swap(arr,0,heapSize-1);
           heapSize--;
           shiftDown(arr,heapSize,0);
        }
    }

    private static void shiftDown(int[] arr, int size, int index) {
        int parent = index;
        int child = parent*2 + 1;
        while (child < size) {
            if (child + 1 < size && arr[child] < arr[child+1]) {
                child = child+1;
            } if (arr[child] > arr[parent]) {
                swap(arr,child,parent);
            } else {
                break;
            }
            parent = child;
            child = 2*parent+1;
        }
    }

    private static void createHeap(int[] arr) {
        for (int i = (arr.length-1-1)/2; i >= 0; i--) {
            shiftDown(arr,arr.length,i);
        }
    }

    public static void bubbleSort(int[] arr) {
       for (int bound = 0; bound < arr.length; bound++) {
           for (int cur = arr.length-1; cur > bound; cur--) {
               if (arr[cur-1] > arr[cur]) {
                   swap(arr,cur-1,cur);
               }
           }
       }
    }
    public static void bubbleSort2(int[] arr) {
        boolean flg = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <arr.length-i-1; j++) {
                flg = false;
            //写成j-1小心数组下标越界
                if (arr[j] > arr[j+1]) {
                    swap(arr,j+1,j);
                    flg = true;
                }
            }
        }
        //所有循环外判定
        if (flg == false) {
            return;
        }
    }

    public static void quickSort(int[] arr) {
        //快速排序
        //借助以下方法辅助递归
        quickSortHelp(arr,0,arr.length-1);
    }

    private static void quickSortHelp(int[] arr,int left,int right) {
       //只有一个元素或者没有的时候就无需比较大小
       //左闭右闭区间
       if (left >= right) {
           return;
       }
       int index = partition(arr,left,right);
       quickSortHelp(arr,left,index-1);
       quickSortHelp(arr,index+1,right);
    }

    private static int partition(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int baseValue = arr[right];
        while (i < j) {
            while (i < j && arr[i] <= baseValue) {
                i++;
            }
            while (i < j && arr[j] >= baseValue) {
                j--;
            }
            if (i < j) {
                swap(arr,i,j);
            }
        }
        swap(arr,i,right);
       return i;
    }
    public static void quickSortByLoop(int[] arr) {
      Stack<Integer> stack = new Stack<>();
      stack.push(0);
      stack.push(arr.length-1);
      while (!stack.isEmpty()) {
       int right = stack.pop();
       int left = stack.pop();
       if (left >= right) {
           continue;
       }
       int index = partition(arr,left,right);
       stack.push(index+1);
       stack.push(right);
       stack.push(left);
       stack.push(index-1);
      }
    }
    public static void mergeSort(int[] arr) {
        mergeSortHelp(arr,0,arr.length);
    }

    private static void mergeSortHelp(int[] arr, int left, int right) {
     if (right-left <= 1) {
         return;
     }
     int mid = (left+right)/2;
     mergeSortHelp(arr,left,mid);
     mergeSortHelp(arr,mid,right);
     merge(arr,left,mid,right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
     int cur1 = left;
     int cur2 = mid;
     int[] output = new int[right-left];
     int outputIndex = 0;
     while (cur1 < mid && cur2 < right) {
         if (arr[cur1] <= arr[cur2]) {
             output[outputIndex] = arr[cur1];
             cur1++;
             outputIndex++;
         } else {
             output[outputIndex] = arr[cur2];
             cur2++;
             outputIndex++;
         }
     }
         while (cur1 < mid) {
             output[outputIndex] = arr[cur1];
             cur1++;
             outputIndex++;
         }
         while (cur2 < right) {
             output[outputIndex] = arr[cur2];
             cur2++;
             outputIndex++;
         }
         for (int i = 0; i < right-left; i++) {
             arr[left+i] = output[i];
         }
       }


    public static void mergeSortByLoop(int[] arr) {
     for (int gap = 1; gap < arr.length; gap*=2) {
         for (int i = 0; i < arr.length;i+=gap*2) {
             int left = i;
             int mid = i+gap;
             int right = i+2*gap;
             if (mid > arr.length) {
                 mid = arr.length;
             }
             if (right > arr.length) {
                 right = arr.length;
             }
             merge(arr,left,mid,right);
         }
     }
    }

    public static void main(String[] args) {
        int []arr={1,5,6,3,2,4,8,7,9,56,42,51,30,22,11,6,0,89};
        mergeSortByLoop(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void main9(String[] args) {
        int []arr={1,5,6,3,2,4,8,7,9,56,42,51,30,22,11,6,0,89};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void main8(String[] args) {
        int []arr={1,5,6,3,2,4,8,7,9,56,42,51,30,22,11,6,0,89};
        quickSortByLoop(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void main7(String[] args) {
        int []arr={1,5,6,3,2,4,8,7,9,56,42,51,30,22,11,6,0,89};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void main6(String[] args) {
        int []arr={1,5,6,3,2,4,8,7,9,56,42,51,30,22,11,6,0,89};
        bubbleSort2(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void main5(String[] args) {
        int []arr={1,5,6,3,2,4,8,7,9,56,42,51,30,22,11,6,0,89};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void main4(String[] args) {
        int []arr={1,5,6,3,2,4,8,7,9,56,42,51,30,22,11,6,0,89};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void main3(String[] args) {
        int []arr={1,5,6,3,2,4,8,7,9,56,42,51,30,22,11,6,0,89};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void main2(String[] args) {
        int []arr={1,5,6,3,2,4,8,7,9,56,42,51,30,22,11,6,0,89};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void main1(String[] args) {
        int []arr={1,5,6,3,2,4,8,9};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
