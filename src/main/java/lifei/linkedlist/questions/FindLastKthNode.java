package lifei.linkedlist.questions;

import lifei.linkedlist.ListNode;
import lifei.linkedlist.SingleLinkedList;

public class FindLastKthNode {

    /**
     * 返回链表长度
     * 
     * @param head
     * @return
     */
    public static int size(ListNode head) {
        if (head.next == null) {
            return 0;
        }

        int size = 0;
        ListNode curr = head.next;

        while (curr != null) {
            size++;
            curr = curr.next;
        }

        return size;
    }

    /**
     * 查找单链表中的倒数第k个节点【新浪面试题】
     * 思路：
     * 1. 编写一个方法，接收两个参数，head节点和整数k
     * 2. 整数k表示倒数第k个节点
     * 3. 先把链表从头到尾开始遍历，得到链表总长度
     * 4. 第(size - k) 就是要找的倒数第k个元素的位置
     * @param head
     * @param k
     * @return
     */
    public static ListNode findLastKthNode(ListNode head, int k) {
        if(head.next == null) {
            System.out.printf("是个空链表，无法找到第[%d]个节点", k);
            return null;
        }
        int size = size(head);
        int j = size - k;
        if (j < 0 || j > size) {
            System.out.printf("链表元素个数只有[%d]个，无法找到倒数第[%d]个节点\n", size, k);
            return null;
        }
        ListNode curr = head.next;

        for (int i = 0; i < size - k; i++) {
            curr = curr.next;
        }

        return curr;
        
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1, "杰伦");
        ListNode n2 = new ListNode(2, "华健");
        ListNode n3 = new ListNode(3, "志玲");
        ListNode n4 = new ListNode(4, "英九");

        SingleLinkedList sll = new SingleLinkedList();

        sll.addByOrder(n1);
        sll.addByOrder(n2);
        sll.addByOrder(n3);
        sll.addByOrder(n4);

        System.out.printf("倒数第[%d]个元素的值是：[%s]\n", 1, FindLastKthNode.findLastKthNode(sll.getHead(), 1));
        System.out.printf("倒数第[%d]个元素的值是：[%s]\n", 2, FindLastKthNode.findLastKthNode(sll.getHead(), 2));
        System.out.printf("倒数第[%d]个元素的值是：[%s]\n", 3, FindLastKthNode.findLastKthNode(sll.getHead(), 3));
        System.out.printf("倒数第[%d]个元素的值是：[%s]\n", 4, FindLastKthNode.findLastKthNode(sll.getHead(), 4));
        System.out.printf("倒数第[%d]个元素的值是：[%s]\n", 5, FindLastKthNode.findLastKthNode(sll.getHead(), 5));
        System.out.printf("倒数第[%d]个元素的值是：[%s]\n", -1, FindLastKthNode.findLastKthNode(sll.getHead(), -1));
    }
}
