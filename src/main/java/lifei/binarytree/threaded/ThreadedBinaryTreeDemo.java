package lifei.binarytree.threaded;

import lifei.AbsAlgorithmExplain;

public class ThreadedBinaryTreeDemo extends AbsAlgorithmExplain {

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
        System.out.println("线索二叉树基本介绍");
        System.out.println(
                "n个节点的二叉链表中含有n+1【公式2n-(n-1)=n+1】个空指针域。利用二叉链表中的空指针域，存放指向该节点在某种遍历次序下的前驱和后继节点的指针，这种附加的指针称为\"线索\"");
        System.out.println("这种加上了线索的二叉链表成为线索链表，相应的二叉树又称为线索二叉树。根据线索性质的不同，线索二叉树可分为前序线索二叉树，中序线索二叉树和后续线索二叉树三种");
        System.out.println("一个节点的前一个节点，称为前驱节点");
        System.out.println("一个节点的后一个节点，称为后继节点");
    }

    @Override
    protected void execute() {
        // TODO Auto-generated method stub

    }

}

class SequentialBinaryTree {

    ListNode pre;

    public void doSequentialBinaryTree(ListNode node) {

        if (node == null) {
            return;
        }

        doSequentialBinaryTree(node.left);

        if (node.left == null) {
            node.left = pre;
            node.leftType = 1;
        }

        if (pre != null && pre.right == null) {
            pre.right = node;
            pre.rightType = 1;
        }

        pre = node;

        doSequentialBinaryTree(node.right);
    }
}

class ListNode {

    int val;

    ListNode left;

    ListNode right;

    // 如果leftType==0, 表示指向的是左子树，如果1表示前驱节点
    // 如果rightType==0, 表示指向的是右子树，如果1表示后继节点
    int leftType;

    int rightType;

    public ListNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}