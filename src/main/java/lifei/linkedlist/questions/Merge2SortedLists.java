package lifei.linkedlist.questions;

import lifei.linkedlist.ListNode;
import lifei.linkedlist.SingleLinkedList;

public class Merge2SortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1, "");
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.num < l2.num) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = (l1 == null) ? l2 : l1;
        return dummy.next;
    }

    /**
     * 递归实现
     * 
     * @param args
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.num < l2.num) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {

        ListNode n1 = new ListNode(1, "杰伦");
        ListNode n2 = new ListNode(2, "华健");
        ListNode n3 = new ListNode(3, "志玲");
        ListNode n4 = new ListNode(4, "英九");
        ListNode n5 = new ListNode(5, "亚轩");
        ListNode n6 = new ListNode(6, "英文");
        ListNode n7 = new ListNode(7, "水扁");
        ListNode n8 = new ListNode(8, "敖");

        SingleLinkedList l1 = new SingleLinkedList();
        l1.addByOrder(n2);
        l1.addByOrder(n7);
        SingleLinkedList l2 = new SingleLinkedList();
        l2.addByOrder(n1);
        l2.addByOrder(n3);
        l2.addByOrder(n4);
        l2.addByOrder(n5);
        l2.addByOrder(n6);
        l2.addByOrder(n8);
        System.out.println("待合并的链表1是\n");
        l1.list();
        System.out.println("待合并的链表2是\n");
        l2.list();

        ListNode newHead = mergeTwoLists(l1.getHead().next, l2.getHead().next);
        ListNode curr = newHead;
        System.out.println("合并后...");
        while (curr != null) {
            System.out.println(curr);
            curr = curr.next;
        }
    }
}
