package lifei.binarytree.heapsort;

import java.util.Arrays;

import lifei.AbsAlgorithmExplain;

public class HeapSortDemo extends AbsAlgorithmExplain {

    public static void main(String[] args) {
        HeapSortDemo hsDemo = new HeapSortDemo();
        hsDemo.run();
    }

    @Override
    protected void extendedIdea() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void basicIdea() {
        System.out.println("堆排序基本思想是：");
        System.out.println("将待排序序列构造成一个打顶堆");
        System.out.println("将其与末尾元素进行交换，此时末尾就为最大值");
        System.out.println("然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了");
        System.out.println("可以看到在构建大顶堆的过程中，元素的个数逐渐减少，最后就得到一个有序的序列了");

    }

    @Override
    protected void introduce() {
        System.out.println("1. 堆排序是利用堆这种数据结构而设计的一种排序算法，堆排序是一种选择排序，它的最好，最坏，平均时间复杂度均为线性对数阶O(nlogn)，它也是不稳定排序");
        System.out.println("2. 堆是具有如下性质的完全二叉树：每个节点的值都大于或等于其他左右孩子节点的值，称为大堆顶，注意：对节点的左子节点和右子节点的大小关系没有要求");
        System.out.println("3. 每个节点的值都小于或等于自己左右子节点的值，称为小堆顶");
        System.out.println("4. 大堆顶举例说明： 50[45[20[10,15],25],40[35,30]]");
        System.out.println("\t我们对堆中的结点按层进行编号，映射到数组中就是下面这个样子");
        System.out.println("\tarray : [0]=50, [1]=45, [2]=40, [3]=20, [4]=25, [5]=35, [6]=30, [7]=10, [8]=15");
        System.out.println("大顶堆特点：arr[i]>=arr[2i+1]&&arr[i]>=arr[2i+2] //i对应第几个节点，i从0开始编号");
        System.out.println("5. 小顶堆举例说明：10[20[25[35,45],50],15[30,40]]");
        System.out.println("\t小顶堆：arr[i]<=arr[2i+1]&&arr[i]<=arr[2i+2] //i对应第几个节点，i从0开始编号");
        System.out.println("6. 一般升序采用大顶堆，降序采用小顶堆");
    }

    @Override
    protected void execute() {
        int arr[] = { 4, 6, 8, 5, 9, -1, 90, 89, 56, -999 };
        heapSort(arr);
    }

    public void heapSort(int[] arr) {
        System.out.println("堆排序");

        // 模拟分步完成
        // convert2Heap(arr, 1, arr.length);
        // System.out.println("第一次 " + Arrays.toString(arr)); // 4,9,8,5,6
        //
        // convert2Heap(arr, 0, arr.length);
        // System.out.println("第二次 " + Arrays.toString(arr));

        int temp = 0;

        // 完整步骤，完成最终代码
        // 将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            convert2Heap(arr, i, arr.length);
        }

        // 2. 将大顶堆元素与末尾元素交换，将最大元素“沉”到数组末端；
        // 3. 重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直至整个数组有序
        for (int j = arr.length - 1; j > 0; j--) {
            // 交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            convert2Heap(arr, 0, j);
        }

        System.out.println("调整后的数组是 " + Arrays.toString(arr));
    }

    /**
     * 功能：完成将以i对应的非叶子节点的非叶子节点的树调整成大顶堆 举例： int arr[] = {4,6,8,5,9}; => i = 1 =>
     * convert2Heap => 得到{4,9,8,5,6} 如果再次调用convert2Heap 传入的是 i = 0 =>
     * 得到{4,9,8,5,6}=>{9,6,8,5,4}
     * 
     * @param arr 待调整的数组
     * @param i 表示非叶子节点在数组中的索引
     * @param length 表示对多少个元素进行调整，length是在逐渐的减少
     */
    public void convert2Heap(int arr[], int i, int length) {
        int temp = arr[i]; // 先取出当前元素的值，保存在临时变量
        // 开始调整
        // 说明
        // 1. k = i * 2 + 1 k是i节点的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) { // 说明左子节点的值小于右子节点的值
                k++; // k指向右子节点
            }
            if (arr[k] > temp) { // 如果子节点大于父节点
                arr[i] = arr[k]; // 把较大的值赋给当前节点
                i = k; // !!! i指向k, 继续循环比较
            } else {
                break;
            }
        }

        // 当for 循环结束后，我们已经将以i为父节点的树的最大值，放在了最顶（局部）
        arr[i] = temp; // 将temp值放到调整后的位置
    }
}
