package lifei.linkedlist.questions;

import lifei.linkedlist.ListNode;
import lifei.linkedlist.SingleLinkedList;

public class CountOfSingleLinkedList {

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
        
        System.out.printf("总共有%d个节点元素", size(sll.getHead()));
    }
}
