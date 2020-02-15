package lifei.sort;

/**
 * ‘采用分治法
 * 
 * @author Fei.Li
 *
 */
public class MergeSort {

    static void mergeSort(int[] arr, int start, int end, int[] tmp) {

        // ‘切分数组到不能再切
        if (start >= end) {
            return;
        }

        // ‘从中间切
        int mid = (start + end) / 2;

        // ‘先分
        mergeSort(arr, start, mid, tmp);
        mergeSort(arr, mid + 1, end, tmp);

        // ‘再治
        merge(arr, start, mid, end, tmp);
    }

    private static void merge(int[] arr, int start, int mid, int end, int[] tmp) {
        int left = start;
        int right = mid + 1;
        int index = start;

        while (left <= mid && right <= end) {
            if (arr[left] < arr[right]) {
                tmp[index++] = arr[left++];
            } else {
                tmp[index++] = arr[right++];
            }
        }

        while (left <= mid) {
            tmp[index++] = arr[left++];
        }

        while (right <= end) {
            tmp[index++] = arr[right++];
        }

        for (index = start; index <= end; index++) {
            arr[index] = tmp[index];
        }
    }

    public static void main(String[] args) {

        int size = 10000000;
        int[] arr = new int[size];
        int[] tmp = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * (size * 10));
        }

        // mergeSort(arr, 0, arr.length - 1, tmp);
        // System.out.printf("排序后的数组是%s\n", Arrays.toString(arr));

        long start = System.currentTimeMillis();
        mergeSort(arr, 0, arr.length - 1, tmp);
        long end = System.currentTimeMillis();
        System.out.printf("归并排序处理元素个数%d个的数组的耗时是%d秒", size, (end - start) / 1000);
    }

}
