package lifei.sort;

import java.util.Arrays;

import lifei.AbsAlgorithmExplain;

public class QuickSort extends AbsAlgorithmExplain {

    static void sort(int[] arr) {

        quickSort(arr, 0, arr.length - 1);
    }

    static void quickSort(int[] arr, int start, int end) {

        // ‘判断start和end的位置，至少需要左右相邻，不能交叉或重叠
        if (start >= end) {
            return;
        }

        int left = start;
        int right = end;

        // ‘拿到中间的值作为枢纽
        int mid = (start + end) / 2;
        int pivot = arr[mid];

        // ‘循环开始，如果left大于right，则循环结束
        while (left <= right) {
            // ‘左侧找大于pivot的值，没找到的话则继续从左向右滑行
            while (left <= right && arr[left] < pivot) {
                left++;
            }
            // ‘右侧找小于pivot的值，没找到的话则继续从右向左滑行
            while (left <= right && arr[right] > pivot) {
                right--;
            }

            // ‘离开上面两个子循环的地方，说明left和right的位置分别是左侧大于pivot的值和右侧小于pivot的值都找到了，因此可以交换位置
            if (left <= right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;

                // ‘交换结束，要移动两个指针到下一个位置
                left++;
                right--;
            }

            // ‘重复上面的处理，直至循环结束
        }

        // ‘循环结束时，left 在 right右边，所以排序可以一分为二(start, right) (left, end)
        quickSort(arr, start, right);
        quickSort(arr, left, end);

    }

    public static void main(String[] args) {
        // int size = 10000000;
        // int[] arr = new int[size];
        //
        // for (int i = 0; i < size; i++) {
        // arr[i] = (int) (Math.random() * (size * 10));
        // }
        int[] arr = { 21, 3, 7, 16, 5, 30, 8, 56, 9 };
        long start = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr));
        // System.out.printf("快速排序处理%d个元素的数组耗时%d秒", size, (end - start) / 1000);
    }

    @Override
    protected void extendedIdea() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void basicIdea() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void introduce() {
        System.out.println("通过一趟排序，将要排序的数据分割成独立的两部分，\n其中一部分的所有数据都比另外一部分的所有数据都要小，\n然后按照此方法对这两部分数据分别\n进行快速排序，整个");
        System.out.println("排序过程可以递归进行，以此达到整个数组变成有序序列");
    }

    @Override
    protected void execute() {
        // TODO Auto-generated method stub

    }
}
