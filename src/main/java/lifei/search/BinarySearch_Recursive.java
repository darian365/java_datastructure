package lifei.search;

import java.util.ArrayList;
import java.util.List;

import lifei.AbsAlgorithmExplain;

public class BinarySearch_Recursive extends AbsAlgorithmExplain {

    public BinarySearch_Recursive() {
    }

    @Override
    protected void extendedIdea() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void basicIdea() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void introduce() {
        System.out.println("二分查找的思路分析");
        System.out.println("1. 首先确定该数组中间的下标");
        System.out.println("mid = (left + right)/2");
        System.out.println("2. 然后让需要查找的数findVal和arr[mid]比较");
        System.out.println("2.1 findVal > arr[mid],说明你要查找d的数在mid的右边，因此需要递归的向右查找");
        System.out.println("2.2 findVal < arr[mid],说明你要查找d的数在mid的左边，因此需要递归的向左查找");
        System.out.println("2.3 findVal == arr[mid]，说明找到，可以返回");
        System.out.println();
        System.out.println("//何时结束递归");
        System.out.println("1. 找到就可以结束递归");
        System.out.println("2. 递归完整个数组，仍然没有找到findVal,也需要结束递归，当left>right就需要退出(仅重合不退出)");
    }

    @Override
    protected void execute() {
        int[] arr = { 1, 8, 10, 89, 1000, 1234 };

        int pos = search(arr, 0, arr.length - 1, 1);
        System.out.println("位置是" + pos);

        pos = search(arr, 0, arr.length - 1, 1000);
        System.out.println("位置是" + pos);

        pos = search(arr, 0, arr.length - 1, 12);
        System.out.println("位置是" + pos);

        int[] arr1 = { 1, 8, 10, 1000, 1000, 1000, 1000, 1234 };
        List<Integer> lst = search2(arr1, 0, arr1.length - 1, 1000);
        System.out.printf("扩展问题的所有结果是 ：");
        lst.stream().forEach(System.out::println);
    }

    /**
     * 采用递归实现的二分查找
     * 
     * @param arr
     * @param left
     * @param right
     * @param val
     * @return
     */
    private int search(int arr[], int left, int right, int val) {

        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (val > arr[mid]) {
            return search(arr, mid + 1, right, val);
        } else if (val < arr[mid]) {
            return search(arr, left, mid - 1, val);
        }
        return mid;
    }

    /**
     * 扩展问题：进行二分搜索，将所有要找的值都返回
     * 
     * @param arr
     * @param left
     * @param right
     * @param val
     * @return
     */
    private List<Integer> search2(int arr[], int left, int right, int val) {

        if (left > right) {
            return new ArrayList<Integer>();
        }

        int mid = (left + right) / 2;

        if (val > arr[mid]) {
            return search2(arr, mid + 1, right, val);
        } else if (val < arr[mid]) {
            return search2(arr, left, mid - 1, val);
        }

        List<Integer> indexList = new ArrayList<Integer>();
        // 往左边遍历
        int temp = mid - 1;
        while (temp >= 0 && arr[temp] == val) {
            indexList.add(temp);
            temp--;
        }
        indexList.add(mid);
        temp = mid + 1;
        while (temp < arr.length && arr[temp] == val) {
            indexList.add(temp);
            temp++;
        }
        return indexList;
    }

    public static void main(String[] args) {
        BinarySearch_Recursive binarySearch_Recursive = new BinarySearch_Recursive();
        binarySearch_Recursive.run();
    }
}
