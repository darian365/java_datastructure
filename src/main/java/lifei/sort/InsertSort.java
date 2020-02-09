package lifei.sort;

import java.util.Arrays;

public class InsertSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {

            int insertValue = arr[i];
            int insertIndex = i - 1;

            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            arr[insertIndex + 1] = insertValue;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 101, 34, 119, 1, -1, 89 };
        sort(arr);
        System.out.println("排序后的数组是 :" + Arrays.toString(arr));

        System.out.println("对长度为10万的数组排序");
        arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100000);
        }
        long start = System.currentTimeMillis();
        sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("对长度10万的数组排序耗时是[ %d]秒: " + (end - start) / 1000); // 4 秒
    }
}
