package lifei.doublelinkedlist;

public class ListNode {

    public int num;

    public String data;

    public ListNode next;

    public ListNode prev;

    public ListNode(int num, String data) {
        this.num = num;
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public String toString() {
        return "NodeItem [num=" + num + ", data=" + data + "]";
    }
}
