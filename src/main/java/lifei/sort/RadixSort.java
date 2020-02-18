package lifei.sort;

import java.util.Arrays;

import lifei.AbsAlgorithmExplain;

/**
 * 基数排序
 * 
 * @author Fei.Li
 *
 */
public class RadixSort extends AbsAlgorithmExplain {

    private int[] arr;

    RadixSort(int[] arr) {
        this.arr = arr;
    }

    public static void main(String[] args) {

        int[] arr = { 53, 3, 542, 748, 14, 214 };
        RadixSort radixSort = new RadixSort(arr);

        radixSort.run();
    }

    @Override
    protected void extendedIdea() {

    }

    @Override
    protected void introduce() {
        System.out.println("\n基数排序核心思想");
        System.out.printf(
                "基数排序(radix sort)属于分配式排序(distribution sort)，\n又称桶排序(bucket sort)或bin sort，它是通过键值的各个位的值\n，将要排序的的元素分配到某些桶中，达到排序的做用。\n");
        System.out.printf("基数排序属于稳定性排序，基数排序法是效率高的稳定性排序");
        System.out.printf("基数排序是桶排序的扩展,速度很快\n");
        System.out.printf("基数排序是经典的空间换时间的方式，占用内存很大，当对海量数据排序时，容易造成OutOfMemoryError\n");
        System.out.println("基数排序是1887年赫尔曼 何乐礼发明的，它是这样实现的，将整数按位数切割成不同的数字，然后按每个位数分别比较");

    }

    @Override
    protected void execute() {

        if (arr == null || arr.length == 0) {
            return;
        }

        // 获取数组内元素最大位数
        int maxLengh = 0;
        int temp = 0;
        for (int i : arr) {
            temp = (int) Math.log10(i) + 1;
            if (maxLengh < temp) {
                maxLengh = temp;
            }
        }

        // 得到了最大位数，可以根据最大位数决定几轮循环的桶处理

        System.out.printf("数组中元素的最大长度是%d\n", maxLengh);

        // 定义一个二维数组，表示10个桶，每个桶是一个一维数组
        // 说明
        // 1. 二维数组包含10个一维数组
        // 2. 为了防止在放入数的时候，数据溢出，则每个一维数组（桶），大小定为arr.length
        // 3. 基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        // 为了记录每个桶中，实际存放了多少个数据，定义一个一维数组来记录各个桶的每次放入的 数据个数
        // 可以理解为 比如 bucketElementCount[0], 记录的就是bucket[0]桶的放入数据个数
        int[] bucketElementCount = new int[10];

        // 对输入数组的每个元素进行遍历
        for (int i = 0, n = 1; i < maxLengh; i++, n *= 10) {
            // 针对每个元素的对应位进行排序处理，第一次是各位，第二次是十位，第三次是百位，以此类推
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
                bucketElementCount[digitOfElement]++;
            }

            // 按照这个桶的顺序，
            int index = 0;
            for (int k = 0; k < bucketElementCount.length; k++) {
                if (bucketElementCount[k] == 0) {
                    continue;
                }
                for (int l = 0; l < bucketElementCount[k]; l++) {
                    arr[index++] = bucket[k][l];
                }
                // 第i+1轮处理后，需要将每个bucketElementCount[k] = 0
                bucketElementCount[k] = 0;
            }
            System.out.printf("第%d次排序后的数组是%s\n", (i + 1), Arrays.toString(arr));
        }
        System.out.printf("排序后的数组是%s\n", Arrays.toString(arr));

    }

    @Override
    protected void basicIdea() {
        System.out.println("\n基本思想");
        System.out.printf("将所有待比较数值统一为同样的数位长度，数位较短的数前面补零。\n然后，从最低位开始，依次进行一次排序。\n这样从最低位排序一直到最高位排序完成以后，数列就变成一个有序序列");
    }

}
