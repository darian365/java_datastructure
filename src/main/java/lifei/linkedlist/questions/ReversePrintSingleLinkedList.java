package lifei.linkedlist.questions;

import java.util.Stack;

import lifei.linkedlist.ListNode;
import lifei.linkedlist.SingleLinkedList;

/**
 * 逆序打印单向链表
 * 
 * @author Fei.Li
 *
 */
public class ReversePrintSingleLinkedList {

    /**
     * 方法一，颠倒链表的顺序后再打印，坏处是链表的顺序被改变了
     * @param node
     */
    public static void reversePrintLinkedList(ListNode head) {

        if (head.next == null) {
            return;
        }

        ListNode newHead = new ListNode(0, "");
        ListNode curr = head.next;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = newHead.next;
            newHead.next = curr;
            curr = next;
        }
        
        System.out.println("颠倒链表后，逆序打印开始：");
        curr = newHead.next;
        while (curr != null) {
            System.out.println(curr);
            curr = curr.next;
        }
    }

    /**
     * 方法二，使用栈，通过压栈和出栈，后进先出的特性来逆序打印，好处是链表的顺序不被改变
     * 
     * @param args
     */
    public static void reversePrintLinkedList1(ListNode head) {
        if (head.next == null) {
            return;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head.next;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        
        System.out.println("使用栈，逆序打印开始：");

        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
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

        reversePrintLinkedList1(sll.getHead());
        reversePrintLinkedList1(sll.getHead());
    }
}
