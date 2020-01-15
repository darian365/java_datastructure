package linkedlist;

public class NodeItem {

    public int num;

    public String data;

    public NodeItem next;

    public NodeItem(int num, String data) {
        this.num = num;
        this.data = data;
        this.next = null;
    }

    public String toString() {
        return "NodeItem [num=" + num + ", data=" + data + "]";
    }
}
