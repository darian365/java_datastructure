package lifei.sort;

import java.util.Arrays;

/**
 * 选择排序的思路是：
 *  一，对数组元素进行循环 from 0 to len - 2
 *  二，需要一个嵌套子循环，在嵌套子循环中找到最小值
 *  三，如果最小值索引是i，那就不需要交换 四，如果最小值索引不是i,那么需要交换 时间复杂度是O(n^2)
 * 
 * @author Fei.Li
 *
 */
public class SelectSort {

    public void selectSort(int[] arr) {

        if (arr == null || arr.length == 0) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {

            int minInd = i;
            int min = arr[i];

            // in loop from i+1 to end, find the min one
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minInd = j;
                }
            }

            // if minInd eq i, then do nothing
            if (minInd != i) {
                // swap the two to make the arr[i] to be min
                arr[minInd] = arr[i];
                arr[i] = min;
            }
        }
    }

    public static void main(String[] args) {

        SelectSort selectSort = new SelectSort();
        int arr[] = new int[] { 101, 34, 139, 1 };
        selectSort.selectSort(arr);
        System.out.println("排序后数组是 : " + Arrays.toString(arr));

        System.out.println("对长度为10万的数组排序");
        arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100000);
        }
        long start = System.currentTimeMillis();
        selectSort.selectSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("对长度10万的数组排序耗时是[ %d]秒: " + (end - start) / 1000);
    }

}
