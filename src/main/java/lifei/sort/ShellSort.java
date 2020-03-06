package lifei.sort;

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

        // ‘增量gap，并逐步地缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // ‘从第gap个元素，逐个对其所在的组进行 直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int tmp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && tmp < arr[j - gap]) {
                        // ‘移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    // ‘当推出while后，就给temp找到插入的位置
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int size = 100000;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * (size * 10));
        }

        long before = System.currentTimeMillis();
        // swapSort(arr);
        moveSort(arr);
        long after = System.currentTimeMillis();
        System.out.printf("排序所花的时间是%d豪秒\n", (after - before));

    }
}
