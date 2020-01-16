package lifei.cyclelinkedlist;

/**
 * 环形单向链表
 * 
 * @author Fei.Li
 *
 */
public class CycleSingleLinkedList {

    private ListNode head = new ListNode(0);

    public ListNode getHead() {
        return head;
    }

    /**
     * 
     * 
     * @param num
     */
    public void add(int num) {
        if (num < 1) {
            return;
        }

        ListNode first = null;
        ListNode cur = null;
        ListNode temp = null;

        for (int i = 1; i <= num; i++) {
            if (i == 1) {
                first = new ListNode(1);
                cur = first;
                cur.next = first;
            } else {
                temp = new ListNode(i);
                cur.next = temp;
                temp.next = first;
                cur = temp;
            }
        }
    }
}

class ListNode {

    public int no;

    public String data;

    public ListNode next;

    public ListNode(int no) {
        this.no = no;
        this.data = "";
    }

    public ListNode(int no, String data) {
        this.no = no;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ListNode [no=" + no + ", data=" + data + "]";
    }

}