package linkedlist.questions;

import linkedlist.NodeItem;
import linkedlist.SingleLinkedList;

public class CountOfSingleLinkedList {

    /**
     * 返回链表长度
     * 
     * @param head
     * @return
     */
    public static int size(NodeItem head) {
        if (head.next == null) {
            return 0;
        }

        int size = 0;
        NodeItem curr = head.next;

        while (curr != null) {
            size++;
            curr = curr.next;
        }

        return size;
    }

    public static void main(String[] args) {
        NodeItem n1 = new NodeItem(1, "杰伦");
        NodeItem n2 = new NodeItem(2, "华健");
        NodeItem n3 = new NodeItem(3, "志玲");
        NodeItem n4 = new NodeItem(4, "英九");

        SingleLinkedList sll = new SingleLinkedList();

        sll.addByOrder(n1);
        sll.addByOrder(n2);
        sll.addByOrder(n3);
        sll.addByOrder(n4);
        
        System.out.printf("总共有%d个节点元素", size(sll.getHead()));
    }
}
