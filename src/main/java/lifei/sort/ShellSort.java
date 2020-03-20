package lifei.sort;

import java.util.Arrays;

/**
 * “希尔排序也是一种插入排序，它是简单插入排序经过改进后的一个更高效的版本，也成为缩小增量排序
 * 
 * “基本思想： “希尔排序是把记录按下标的一定增量分组，对没组使用直接插入排序算法，随着增量逐渐减少，
 * “每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止
 * 
 * @author Fei.Li
 *
 */
public class ShellSort {

    /**
     * “交换方式： 对有序序列在插入时采用交换法，并测试排序速度
     * 
     * @param arr
     */
    static void swapSort(int[] arr) {

        if (arr == null || arr.length == 0) {
            return;
        }

        int count = 0;
        int tmp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        tmp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = tmp;
                    }
                }
            }
            // System.out.printf("第%d轮排序后的数组是%s\n", (++count),
            // Arrays.toString(arr));
        }
    }

    /**
     * “移动方式 ： 对有序序列在插入时采用移动法，并测试排序速度
     * 
     * @param arr
     */
    static void moveSort(int[] arr) {
        // ’10，9，8，7，6，5，4，3，2，1
        if (arr == null || arr.length == 0) {
            return;
        }

        int countOfExchange = 0;

        // handle the gap of incremental and eliminate the incremental each time
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // use insertion sort for each group starting from the gap-th item
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int tmp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && tmp < arr[j - gap]) {
                        // move the smaller value from right to left
                        arr[j] = arr[j - gap];
                        // do the comparison gap by gap
                        j -= gap;
                    }
                    // find the right position to insert the value
                    arr[j] = tmp;
                    countOfExchange++;
                }
            }
        }
        System.out.printf("countOfExchange : %d\n", countOfExchange);
    }

    public static void main(String[] args) {
        int size = 20;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * (size * 10));
        }
        arr = new int[] { 12, 9, 4, 99, 120, 1, 3, 10, 23, 45, 75, 69, 31, 88, 101, 14, 29, 91, 2, 0, 77 };
        long before = System.currentTimeMillis();
        // swapSort(arr);
        moveSort(arr);
        long after = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr));
        System.out.printf("排序所花的时间是%d豪秒\n", (after - before));

    }
}
