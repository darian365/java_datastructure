package lifei.sort;

import java.util.Arrays;

import lifei.AbsAlgorithmExplain;

/**
 * 选择排序的思路是： (原文)： 第一次从arr[0]~arr[n-1]中选取最小值，与arr[0]交换。
 * 第二次从arr[1]~arr[n-1]中选取最小值，与arr[1]交换。 第三次从arr[2]~arr[n-1]中选取最小值，与arr[2]交换。
 * 第i次从arr[i-1]~arr[n-1]中选取最小值，与arr[i-1]交换。
 * 第n-1次从arr[n-2]~arr[n-1]中选取最小值，与arr[n-2]交换。 总共通过n-1次，得到一个按排位码从小到大排列的有序序列。
 * 
 * @author Fei.Li
 *
 */
public class SelectSort extends AbsAlgorithmExplain {

    private int[] arr;

    public SelectSort(int[] arr) {
        this.arr = arr;
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 101, 34, 139, 1 };
        SelectSort selectSort = new SelectSort(arr);

        System.out.printf("排序后数组是 :%s \n", Arrays.toString(arr));
        selectSort.run();
        System.out.printf("排序后数组是 :%s \n\n", Arrays.toString(arr));

        // System.out.println("对长度为10万的数组排序");
        // arr = new int[100000];
        // for (int i = 0; i < arr.length; i++) {
        // arr[i] = (int) (Math.random() * 100000);
        // }
        // long start = System.currentTimeMillis();
        // selectSort.selectSort(arr);
        // long end = System.currentTimeMillis();
        // System.out.println("对长度10万的数组排序耗时是[ %d]秒: " + (end - start) / 1000);

    }

    @Override
    protected void extendedIdea() {
        System.out.println("\n个人理解心得\n");

    }

    @Override
    protected void introduce() {
        System.out.println("\n选择排序的思路是： (原文)：");
        System.out.println("第一次从arr[0]~arr[n-1]中选取最小值，与arr[0]交换。");
        System.out.println("第二次从arr[1]~arr[n-1]中选取最小值，与arr[1]交换。");
        System.out.println("第三次从arr[2]~arr[n-1]中选取最小值，与arr[2]交换。");
        System.out.println("第i次从arr[i-1]~arr[n-1]中选取最小值，与arr[i-1]交换。");
        System.out.println("第n-1次从arr[n-2]~arr[n-1]中选取最小值，与arr[n-2]交换。");
        System.out.println("总共通过n-1次，得到一个按排位码从小到大排列的有序序列。");
    }

    @Override
    protected void execute() {
        if (arr == null || arr.length == 0) {
            return;
        }
        // ‘循环n-2次
        for (int i = 0; i < arr.length - 1; i++) {

            // 定义最小值索引的初始值和最小值的初始值
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
            System.out.printf("第%d次循环后的结果是%s\n", i + 1, Arrays.toString(arr));
        }
    }

    @Override
    protected void basicIdea() {
    }
}
