package lifei.binarytree;

import lifei.AbsAlgorithmExplain;

/**
 * 
 * @author Fei.Li
 *
 */
public class ArrayBinaryTreeDemo extends AbsAlgorithmExplain {

    public static void main(String[] args) {
        ArrayBinaryTreeDemo abtdDemo = new ArrayBinaryTreeDemo();
        abtdDemo.run();
    }

    @Override
    protected void extendedIdea() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void basicIdea() {
        System.out.println("****************************");
        System.out.println("顺序存储二叉树的特点");
        System.out.println("顺序二叉树通常只考虑完全二叉树");
        System.out.println("第n个元素的左子节点为2*n+1");
        System.out.println("第n个元素的右子节点为2*n+2");
        System.out.println("第n个元素的父节点为(n-1)/2");
        System.out.println("n:表示二叉树中的第几个元素（可等同于数组的索引编号）");
        System.out.println("****************************");
    }

    @Override
    protected void introduce() {
        System.out.println("顺序存储二叉树");

    }

    @Override
    protected void execute() {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        ArrayBinaryTree abt = new ArrayBinaryTree(arr);
        abt.preOrder(0);
        System.out.println();
        abt.infixOrder(0);
        System.out.println();
        abt.postOrder(0);
    }
}

class ArrayBinaryTree {

    private int[] arr; // 存储数据节点的数组

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 前序遍历 顺序存储二叉树
     * 
     * @param n 数组的下标
     */
    public void preOrder(int n) {
        if (this.arr == null || this.arr.length == 0) {
            System.out.println("无法遍历空数组");
            return;
        }
        System.out.printf("%d ", arr[n]);
        if (2 * n + 1 < arr.length) {
            preOrder(2 * n + 1);
        }
        if (2 * n + 2 < arr.length) {
            preOrder(2 * n + 2);
        }
    }

    /**
     * 中序遍历 顺序存储二叉树
     * 
     * @param n 数组的下标
     */
    public void infixOrder(int n) {
        if (this.arr == null || this.arr.length == 0) {
            System.out.println("无法遍历空数组");
            return;
        }
        if (2 * n + 1 < arr.length) {
            infixOrder(2 * n + 1);
        }

        System.out.printf("%d ", arr[n]);

        if (2 * n + 2 < arr.length) {
            infixOrder(2 * n + 2);
        }
    }

    /**
     * 后序遍历 顺序存储二叉树
     * 
     * @param n 数组的下标
     */
    public void postOrder(int n) {
        if (this.arr == null || this.arr.length == 0) {
            System.out.println("无法遍历空数组");
            return;
        }
        if (2 * n + 1 < arr.length) {
            postOrder(2 * n + 1);
        }

        if (2 * n + 2 < arr.length) {
            postOrder(2 * n + 2);
        }

        System.out.printf("%d ", arr[n]);
    }
}
