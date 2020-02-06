package lifei.recursion.queens8;

/**
 * 八皇后问题算法思路分析
 * 1. 第一个皇后放在第一行第一列
 * 2. 第二个皇后放在第二行第一列，然后判断是否OK,如果不OK，挪到第二列，以此类推，直到找到OK的位置
 * 3. 继续第三个皇后，还是第一列，第二列，直到第8个皇后也能放到一个不冲突的位置，算是找到了一个正确的解
 * 4. 当得到一个正确的解时，在栈回退到上一个栈时，就会开始回溯，即，将最后一个皇后，放到第一列的所有正确解，全部得到
 * 5. 然后回头 继续第一个皇后放第二列，后面继续循环执行1，2，3，4的步骤
 * 
 * 说明：理论上应该创建一个二维数组来表示棋盘，但是实际上可以通过算法，用一个一维数组jji即可解决问题. 
 * arr[8] = {0,4,7,5,2,6,1,3} // 对应arr的下标表示第几行，即第几个皇后
 * arr[i] = val, val表示第i+1个皇后，放在第i+1行的第val+1列
 * 
 * @author Fei.Li
 *
 */
public class Queen8 {

    // 定义一个max表示共有多少个皇后
    int max = 8;

    // 定义数组array, 保存皇后的位置的结果，比如array = {0, 4, 7, 5, 2, 6, 1, 3}
    int[] array = new int[max];

    public static void main(String[] args) {

    }

    /**
     * 放置第n个皇后
     * 
     * @param int n
     * 
     */
    private void place(int n) {
        if (n >= max) {
            System.out.printf("%d个皇后已摆放完毕", n);
            return;
        }
        // 依次每列放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            array[n] = i;
            // 判断第n个皇后到达第i列时，是否有冲突
            if (validate(n)) {
                // 不冲突则放下一行的皇后
                place(n + 1);
            }
            // 如果冲突，就继续执行array[n] = i(继续循环内后移),即将第n个皇后，放置在本行的后移的位置
        }
    }

    /**
     * 查看当我们放置第n个皇后，检测该皇后是否和已拜访的皇后冲突，即不在同一行或同一列或同一斜线
     * 
     * @param n 第n个皇后
     * @return
     */
    private boolean validate(int n) {
        for(int i = 0; i < n; i ++) {
            // 如果是同一列
            if (array[i] == array[n]) {
                return false;
            }
            // 如果是同斜线
            else if (Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
            // 如果是同一行，不需要判断，因为n是递增的（本次n和下次 n相比较）
        }
        return true;
    }

}
