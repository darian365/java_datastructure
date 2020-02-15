package lifei.sort;

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

    }

    @Override
    protected void extendedIdea() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void coreIdea() {
        // TODO Auto-generated method stub

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
    }

}
