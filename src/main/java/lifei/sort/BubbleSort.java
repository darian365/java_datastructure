package lifei.sort;

import java.util.Arrays;

/**
 * 一：一共进行循环次数是数组长度-1次 二：每次循环的元素个数会逐渐减少 。 三：优化的地方，如果某次循环没有发现交换，可以提前结束冒泡排序。这个就是优化
 * 
 * @author Fei.Li
 */
public class BubbleSort {

    public void bubbleSort(int arr[]) {

        if (arr == null || arr.length == 0) {
            return;
        }

        int tmp = 0;

        boolean noSwap = false;

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {
                    noSwap = true;
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            // no swap for current loop
            if (!noSwap) {
                break;
            } else {
                // reset for next swap
                noSwap = false;
            }

            // System.out.println("第" + (i + 1) + "次排序的结果 : " + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {

        int[] arr = { 20, 10, 5, 2, -1 };

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(arr);
        System.out.println("排序后的结果是 : " + Arrays.toString(arr));

        System.out.println("对长度为10万的数组排序");
        arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100000);
        }
        long start = System.currentTimeMillis();
        bubbleSort.bubbleSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("对长度10万的数组排序耗时是[ %d]秒: " + (end - start) / 1000);
    }

}
