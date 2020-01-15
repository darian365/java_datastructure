package linkedlist.questions;

import linkedlist.NodeItem;

public class ReverseSingleLinkedList {

    public NodeItem reverseLinkedList(NodeItem head) {

        if (head.next == null) {
            System.out.println("这是一个空链表，不能翻转。");
            return null;
        }

        NodeItem newHead = new NodeItem(0, "");
        NodeItem curr = head.next;
        NodeItem next = null;
        while (curr.next != null) {
            next = curr.next;
            curr.next = head.next;
            newHead.next = curr;
            curr.next = next;
        }

        return newHead;
    }

    public static void main(String[] args) {

    }
}
