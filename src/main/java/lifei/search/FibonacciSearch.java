package lifei.search;

import java.util.Arrays;

import lifei.AbsAlgorithmExplain;

public class FibonacciSearch extends AbsAlgorithmExplain {

    public static int maxSize = 20;

    @Override
    protected void extendedIdea() {
        System.out.println("对于斐波那契数列：1、1、2、3、5、8、13、21、34、55、89……（也可以从0开始），");
        System.out.println("前后两个数字的比值随着数列的增加，越来越接近黄金比值0.618。比如这里的89，");
        System.out.println("把它想象成整个有序表的元素个数，而89是由前面的两个斐波那契数34和55相加之后的和，");
        System.out.println("也就是说把元素个数为89的有序表分成由前55个数据元素组成的前半段和由后34个数据元素组成的后半段，");
        System.out.println("那么前半段元素个数和整个有序表长度的比值就接近黄金比值0.618，假如要查找的元素在前半段，那么继续");
        System.out.println("按照斐波那契数列来看，55 = 34 + 21，所以继续把前半段分成前34个数据元素的前半段和后21个元素的后");
        System.out.println("半段，继续查找，如此反复，直到查找成功或失败，这样就把斐波那契数列应用到查找算法中了。");

    }

    @Override
    protected void basicIdea() {
        System.out.println(
                "斐波那契搜索就是在二分查找的基础上根据斐波那契数列进行分割的。\n"
                        + "在斐波那契数列找一个等于略大于查找表中元素个数的数F[n]，\n"
                        + "将原查找表扩展为长度为F[n](如果要补充元素，则补充重复最后一个元素，\n"
                        + "直到满足F[n]个元素)，完成后进行斐波那契分割，即F[n]个元素分割为前半部分F[n-1]个元素，\n"
                        + "后半部分F[n-2]个元素，找出要查找的元素在那一部分并递归，直到找到。");
    }

    @Override
    protected void introduce() {
        System.out.println("斐波那契是区间中单峰函数的搜索技术");
        System.out.println("斐波那契查找的时间复杂度还是O(logN)");
        System.out.println("，但是与折半查找相比，斐波那契查找的优");
        System.out.println("点是它只涉及加法和减法运算，而不用除法，");
        System.out.println("而除法比加减法要占用更多的时间，因此，斐波那契查找的运行时间理论上比折半查找小");

    }

    @Override
    protected void execute() {
        int[] arr = { 1, 8, 10, 89, 1000, 1024 };
        int pos = fibonacciSearch(arr, 1000);
        System.out.println("被查找的值的位置是:" + pos);
    }

    /**
     * 该方法使用非递归方式得到一个到斐波那契数列
     * 
     * @return
     */
    private static int[] fib() {
        int[] arr = new int[maxSize];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i < maxSize; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }

        return arr;
    }

    /**
     * 斐波那契查找方法，使用非递归方式 需要用公式mid = low+F(k-1)-1
     * 
     * @param arr 要查找的数组
     * @param key 要查找的值
     * @return 返回对应的下标，如果没有-1
     */
    public int fibonacciSearch(int[] arr, int key) {

        int low = 0;
        int high = arr.length - 1;
        int k = 0; // 表示斐波那契分割数值的下标
        int mid = 0; // 存放mid的值
        int f[] = fib(); // {1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765}

        // 获取斐波那契分割数值的下标
        // high = 5, k = 5时 f[5] = 8 跳出循环
        while (high > f[k] - 1) {
            k++;
        }

        // 因为f[k]的值可能大于arr数组的长度，所以需要构造一个指向arr的新数组
        // 结合输入数组的实例，f[5] = 8，数组arr的长度是6，所以创建出的新数组会多出两个元素
        int[] temp = Arrays.copyOf(arr, f[k]);
        // 不足的部分会补0

        // 补0的部分需要用arr数组最大的数来填充
        // 比如： {1, 8, 10, 89, 1000, 1024, 1024, 1024}
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        // 开始查找key
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {
                high = mid - 1;
                // 为什么是k--
                // 因为
                // 1. 全部元素=前面元素+后边元素
                // 2. f[k] = f[k-1] + f[k-2]
                // 因为前面有f[k-1]个元素，所以可以继续拆分f[k-1]=f[k-2]+f[k-3]
                // 即在f[k-1]的前面继续查找k--
                // 即下次循环mid = f[k-1-1]-1
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                // 为什么是k-=2
                // 说明
                // 1. 全部元素 = 前面的元素 + 后边的元素
                // 2. f[k] = f[k-1] + f[k-2]
                // 3. 因为后面有f[k-2] 所以可以继续拆分f[k-2] = f[k-3] + f[k-4]
                // 4. 即在f[k-2]的前面进行查找k-=2
                // 5. 即下次循环mid = f[k-1-2] - 1
                k -= 2;
            }

            // 返回小的
            if (mid <= high) {
                return mid;
            }
            return high;
        }

        return -1;
    }

    public static void main(String[] args) {

        FibonacciSearch fibonacciSearch = new FibonacciSearch();
        fibonacciSearch.run();
    }

}
