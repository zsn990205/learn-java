

//插入排序和希尔排序

import java.util.*;

public class Sort {
    //(0,bound]已排序区间
    //(bound,size]未排序区间
    //插入排序的时间复杂度是O(n方) 空间复杂度是O(1)
    public static void insertSort(int []arr) {
        for (int bound = 0; bound < arr.length; bound++) {
            int tmp = arr[bound];
            int cur = bound - 1;

            //从后向前找到合适位置插入
            for (; cur >= 0; cur--) {
            //就相当于 拿着未排序的数组中的第一个数字和已排序的数组比较 看它应该放在哪 必须是tmp
            //arr[bound]是变化的
            //cur从0开始 --后就是-1  到后面arr[cur+1]就是arr[0]
            //因为插入排序是较为稳定的排序(先来的排在前面) 所以这儿只要>没有=
            //如果是=的话 比如7 7 这个时候后面的7就会顶替前面的7 此时就是不稳定的排序
            if(arr[cur]>tmp) {
                arr[cur+1]=arr[cur];
            }
            else {
                break;
            }
            }
            //将cur的元素向后搬运 tmp向前比较
             arr[cur+1]=tmp;
        }
    }
    public static void shellSort(int []arr) {
        //先去筛选分组序列  都有size,size/2,size/4,size/8.....1;
        int gap=arr.length/2;
        while(gap>1) {
            insertSortGap(arr,gap);
            gap=gap/2;
        }
          insertSortGap(arr,1);
    }

    private static void insertSortGap(int[] arr,int gap) {
        for(int bound=gap;bound<arr.length;bound++) {
            //从每组下表为1的数开始
            int tmp = arr[bound];
            // 找到bound位置的相邻的前一个元素
            int cur = bound - gap;
            for (; cur >= 0; cur -= gap) {
                if (arr[cur] > tmp) {
                    arr[cur + gap] = arr[cur];
                } else {
                    break;
                }
            }
            arr[cur + gap] = tmp;

        }
    }
    public static void selectSort(int []arr) {
        //选择排序(升序) 每次选出数组中最小的元素
        //[0,bound)已排序区间
        //[bound,size)待排序区间
        for(int bound=0;bound<arr.length;bound++) {
            for(int cur=bound;cur<arr.length;cur++) {
                if(arr[cur]<arr[bound]) {
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
        //先建立一个大堆
        createHeap(arr);
        //这个用来表示堆的大小
        int heapSize=arr.length;
        //少循环一次 是因为堆里就剩一个元素就不用删除了
        for(int i=0;i<arr.length-1;i++) {
        //每次取堆顶元素和堆中最后一个元素进行交换 并且删除最后一个元素
            swap(arr,0,heapSize-1);
            heapSize--;
         // 然后进行向下调整(继续建立一个大堆)
            shiftDown(arr,heapSize,0);
        }
    }

    private static void shiftDown(int[] arr, int size,int index) {
        int parent=index;
        int child=2*parent+1;
        while(child<size) {
            if(child+1<size && arr[child]<arr[child+1]) {
                child=child+1;
            //此时child指向谁已经不清楚了 但是我们可以知道child始终指向最大的元素
            } if(arr[child]>arr[parent]) {
                swap(arr,child,parent);
            }
            else {
                break;
            }
             parent=child;
             child=2*parent+1;
        }
    }

    private static void createHeap(int[] arr) {
        for(int i=(arr.length-1-1)/2;i>=0;i--) {
            shiftDown(arr,arr.length,i);
        }
    }
    public static void bubbleSort(int []arr) {
    //从后向前遍历 每次找最小放在前面(升序)
    //[0,bound)已排序
    for(int bound=0;bound<arr.length;bound++) {
    //[bound,size)未排序
     for(int cur=arr.length-1;cur>bound;cur--) {
            if(arr[cur-1]>arr[cur]) {
                swap(arr,cur-1,cur);
            }
        }
    }
    }
    public static void bubbleSort2(int []arr) {
    //冒泡排序的进阶(好!)
        boolean flg=false;
        for(int i=0;i<arr.length;i++) {
        flg=false;
            for(int j=0;j<arr.length-i-1;j++) {
                if(arr[j]>arr[j+1]) {
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                    flg=true;
                }
            }
        }
        if(flg=false) {
            return;
        }
    }
    public static void quickSort(int []arr) {
    //核心操作:partition
    //partition:基于基本元素左侧的数字排好序了(比基准值小) 右侧亦然(大)
    //A:如果是基本元素在最后一个的话:一定要先从左往右找比基准值大的元素 在从右往左找比基准值小的元素 交换
    // 最后left和right重和  重合的这个元素一定比基准值大
    //B:如果是第一个的话:先从右往左在从左往右 重合的这个元素一定比基准值小

    //借助辅助方法进行递归
    quickSortHelp(arr,0,arr.length-1);
    }

    //[left,right]
    private static void quickSortHelp(int[] arr, int left, int right) {
    if(left>=right) {
    //0个元素或者一个元素 不需要调整
        return;
    }
    //整理之后 基准值的位置
    int index=partition(arr,left,right);
    //左右区间递归调整
    //左区间[left,index-1]
    //右区间[index+1,right]
    quickSortHelp(arr,left,index-1);
    quickSortHelp(arr,index+1,right);
    }

    private static int partition(int[] arr, int left, int right) {
        int baseValue=arr[right];
        int i=left;
        int j=right;
        while(i<j) {
        //先从左往右找到一个比基准值大的元素
        while(i<j && arr[i]<=baseValue) {
            i++;
        }
        //此时i要么与j重合 要么i的值比基准值大

        //接着从右往左找到比基准值小的元素
        while(i<j && arr[j]>=baseValue) {
            j--;
        }
        //此时i要么与j重合 要么j的值比基准值小

        if(i<j) {
                swap(arr,i,j);
            }
        }
        //此时i和j重合(重合的数字一定比基准值大) 交换i和基准值的数字 并且此时i就是基准值
        swap(arr,i,right);
        return i;
    }
    public static void quickSortByLoop(int[] arr) {
    //借助一个栈 相当于二叉树中的前序
    //栈中保存的相当于进行partition操作范围的下标
    Stack<Integer> stack=new Stack<>();
    stack.push(0);
    stack.push(arr.length-1);
    while(!stack.isEmpty()) {
    //陷入栈的元素最后出来 所以最左侧的就是最后一个出栈
    int right=stack.pop();
    int left=stack.pop();
    if(left>=right) {
    //空 或者只有一个元素 不需要找partition操作
        continue;
    }
    int index=partition(arr,left,right);
    //先将右子树入栈 [index+1]
    stack.push(index+1);
    stack.push(right);
    //再将左子树入栈 [left,index-1]
    stack.push(left);
    stack.push(index-1);
    }
    }

    public static void mergeSort(int[] arr) {

        mergeSortHelp(arr,0,arr.length);
    }

    private static void mergeSortHelp(int[] arr, int left, int right) {
    //[) 二路归并排序是前闭后开区间
        if(right-left<=1) {
            return;
        }
    //通过这个递归的条件 我们可以最终将数组划分为 仅剩一个元素的数组 此时就无需排序了
        int mid=(left+right)/2;
        mergeSortHelp(arr,left,mid);
        mergeSortHelp(arr,mid,right);
    //此时数组为分块的已经拍好的数组 然后进行单独数组的合并操作
        merge(arr,left,mid,right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int cur1=left;
        int cur2=mid;
        int[] output=new int[right-left];
    //表示当前output数组被插入了几个元素
        int outputIndex=0;
        while(cur1<mid && cur2<right) {
    //此时必须是< = 不能是<  因为归并是稳定的
            if(arr[cur1] <= arr[cur2]) {
                output[outputIndex]=arr[cur1];
                cur1++;
                outputIndex++;
            } else {
    //此时 arr[cur2]<arr[cur1]
                output[outputIndex]=arr[cur2];
                cur2++;
                outputIndex++;
            }
            }
    //下面这两个循环 只能进一个
        while(cur1<mid) {
            output[outputIndex]=arr[cur1];
            cur1++;
            outputIndex++;
        }
        while(cur2<right) {
            output[outputIndex]=arr[cur2];
            cur2++;
            outputIndex++;
        }
    //最后一步将元素拷贝 left-right进行合并
        for(int i=0;i<right-left;i++) {
            arr[left+i]=output[i];
        }
    }
    public static void mergeSortByLoop(int[] arr) {
    //gap表示元素个数
        for(int gap=1;gap<arr.length;gap*=2) {
            for(int i=0;i<arr.length;i+=2*gap) {
    //[i,i+gap)
    //[i+gap,i+2*gap)
                int left=i;
                int mid=i+gap;
                int right=i+2*gap;
                if(mid>arr.length) {
                    mid=arr.length;
                }
                if(right>arr.length) {
                    right=arr.length;
                }
                merge(arr,left,mid,right);
            }
        }

    }

    public static void main11(String[] args) {
        int []arr={1,5,6,3,2,4,8,7,9,56,42,51,30,22,11,6,0,89};
        mergeSortByLoop(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void main10(String[] args) {
        int []arr={1,5,6,3,2,4,8,7,9,56,42,51,30,22,11,6,0,89};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void main9(String[] args) {
        int []arr={1,5,6,3,2,4,8,7,9,56,42,51,30,22,11,6,0,89};
        quickSortByLoop(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void main8(String[] args) {
    //idea中给出的排序方法<集合类>
        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(9);
        arrayList.add(5);
        arrayList.add(2);
        arrayList.add(7);
        arrayList.add(3);
        arrayList.add(6);
        arrayList.add(8);

        Collections.sort(arrayList);
        System.out.println(arrayList);

    //数组中的排序方法
        int[] arr={9,5,4,6,8,9,2};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void main7(String[] args) {
        int []arr={9,5,2,7,1,3,8,6};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void main6(String[] args) {
        int []arr={9,5,2,7,1,3,8,6};
        bubbleSort2(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void main5(String[] args) {
        int []arr={9,5,2,7,1,3,8,6};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void main4(String[] args) {
        int []arr={9,5,2,7,1,3,8,6};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void main3(String[] args) {
        int []arr={9,5,2,7,1,3,8,6};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void main2(String[] args) {
        int []arr={9,5,2,7,1,3,8,6};
        shellSort(arr);
        System.out.print(Arrays.toString(arr));
    }
    public static void main1(String[] args) {
        int []arr={9,8,5,7,6,4,1,2,3};
        insertSort(arr);
        System.out.print(Arrays.toString(arr));
    }
}
