package lifei.linkedlist.questions;

import lifei.linkedlist.NodeItem;
import lifei.linkedlist.SingleLinkedList;

public class ReverseSingleLinkedList {

    public static void reverseLinkedList(NodeItem head) {

        // 如果是空链表 或者 只有一个节点，则不需翻转
        if (head.next == null || head.next.next == null) {
            return;
        }

        // 创建一个新头节点，用来指向翻转的节点
        NodeItem newHead = new NodeItem(0, "");
        // 创建一个辅助节点，用来遍历原链表
        NodeItem curr = head.next;
        // 创建一个指向下一节点的辅助指针
        NodeItem next = null;
        // 如果当前节点不为空，则循环继续
        // 每遍历一个节点，就摘出来放到新头节点后
        while (curr != null) {
            next = curr.next; // 当前节点的下一节点保存到next做迭代使用
            curr.next = newHead.next; // 将摘出的当前节点的下一节点指向新头节点的下一节点
            newHead.next = curr; // 再将新头节点的下一节点指向当前节点，使新头节点.next->当前节点.next->新头节点的原来指向的节点
            curr = next; // 将curr继续从原节点的下个节点开始遍历
        }

        // 将老头节点连接新链表的第一个节点
        head.next = newHead.next;
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

        System.out.println("翻转前~");
        sll.list();

        reverseLinkedList(sll.getHead());
        System.out.println("翻转后~");
        sll.list();
    }
}
