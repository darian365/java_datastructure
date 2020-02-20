package lifei.search;

import lifei.AbsAlgorithmExplain;

public class InsertionSearch extends AbsAlgorithmExplain {

    @Override
    protected void extendedIdea() {
        System.out.println("注意事项");
        System.out.println("对于数组中数据量大，元素分布均匀的数组来说，采用插值查找，速度较快");
        System.out.println("元素分布不均匀的情况下，插值查找不一定比二分查找好");
    }

    @Override
    protected void basicIdea() {
        System.out.println("插值查找算法的举例说明");
        System.out.println("数组 arr = [1,2,3,......,100]");
        System.out.println("假如我们需要查找的值1");
        System.out.println("使用二分查找的话，我们需要5~到6次递归，才能找到1");
        System.out.println("使用插值查找算法");
        System.out.println("利用公式mid = left + (right - left)*(key - a[left])/(a[right]-a[left])");
        System.out.println("int mid = 0 + (99 - 0)*(1 - 1)/(100 - 1) = 0 + 99*0/99 = 0");
        System.out.println("比如我们查找的值100");
        System.out.println("int mid = 0 + (99 - 0) * (100 - 1)/(100 - 1) = 0 + 99 * 99/99 = 99");
    }

    @Override
    protected void introduce() {
        System.out.println("插值查找原理介绍");
        System.out.println("1. 插值查找算法类似于二分查找，不同的是插值查找每次从自适应mid处开始查找。");
        System.out.println("2. 将折半查找中的求mid索引的公式, low表示左边索引left, high表示右边索引right. key就是要找的值findVal");
        System.out.println();
        System.out.println(
                "找mid的公式mid = (low + high)/2 = low + 1/2(high - low) 可以替换为mid = low + (high - low)*(key - a[low])/(a[high]-a[low])");
        System.out.println();
        System.out.println("3. 对应的公式可以用left和right替换，即 mid = left + (right - left)*(key - a[left])/(a[right]-a[left])");
        System.out.println("4. 举例说明插值算法查找 1 - 100 的数组");
    }

    @Override
    protected void execute() {

        int[] arr = { 1, 8, 10, 89, 1000, 1234 };
        // int pos = search(arr, 0, arr.length - 1, 1);
        // System.out.println("位置是" + pos);

        // int pos1 = search(arr, 0, arr.length - 1, 1000);
        // System.out.println("位置是" + pos1);
        //
        int pos2 = search(arr, 0, arr.length - 1, 89);
        System.out.println("位置是" + pos2);

    }

    private int search(int[] arr, int left, int right, int val) {
        if (left > right || val < arr[0] || val > arr[arr.length - 1]) {
            return -1;
        }

        System.out.println("查找方法被调用");
        int mid = left + (right - left) * (val - arr[left]) / (arr[right] - arr[left]);

        if (val > arr[mid]) {
            return search(arr, mid + 1, right, val);
        } else if (val < arr[mid]) {
            return search(arr, left, mid - 1, val);
        }
        return mid;
    }

    public static void main(String[] args) {
        InsertionSearch insertionSearch = new InsertionSearch();
        insertionSearch.run();
    }
}
