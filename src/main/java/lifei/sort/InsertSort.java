package lifei.sort;

import java.util.Arrays;

/**
 * “基本思想： “把n个待排序的元素看成一个有序表和一个无序表，开始时有序表中只包含一个元素，无序表中包含n-1个元素，
 * “排序过程中每次从无序表中取出第一个元素，把它的排序码依次和有序表元素的排序码进行比较，将它插入到 “有序表中的适当位置，使之成为新的有序表
 * 
 * @author Fei.Li
 *
 */
public class InsertSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int countOfExchange = 0;

        for (int i = 1; i < arr.length; i++) {
            // “定义待插入的数，默认是i位置
            int insertValue = arr[i];
            // “定义待插入的索引位置
            int insertIndex = i - 1;

            // “给insertVal找到插入的位置
            // “说明
            // “1. insertIndex >= 0 保证在给insertValue找插入位置时不越界
            // “2. insertValue < arr[insertIndex] 待插入的数，还没有找到插入位置
            // “3. 就需要将arr[insertIndex]后移
            // “4. 通过演绎推导，循环内会将比待插入的值大的都逐个后移，最后insertIndex == -1 跳出循环
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            // “当while循环结束时，说明插入位置找到了，即insertIndex + 1
            arr[insertIndex + 1] = insertValue;
            countOfExchange++;
        }

        System.out.printf("countOfExchange : %d\n", countOfExchange);
    }

    public static void main(String[] args) {
        int arr[] = { 101, 34, 119, 1, -1, 89 };
        sort(arr);
        System.out.println("排序后的数组是 :" + Arrays.toString(arr));

        System.out.println("对长度为10万的数组排序");
        arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100000);
        }
        long start = System.currentTimeMillis();
        sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("对长度10万的数组排序耗时是[ %d]秒: " + (end - start) / 1000); // 4
                                                                             // 秒
    }
}
