package lifei.cyclelinkedlist;

/**
 * 环形单向链表
 * 
 * @author Fei.Li
 *
 */
public class CycleSingleLinkedList {

    // 创建一个first节点，用来指向第一个节点
    private ListNode first = new ListNode(-1);

    public ListNode getHead() {
        return first;
    }

    /**
     * 添加节点
     * 
     * @param num
     */
    public void add(int num) {
        if (num < 1) {
            System.out.println("num需要至少一个节点");
            return;
        }

        ListNode cur = null;

        for (int i = 1; i <= num; i++) {
            ListNode temp = new ListNode(i);
            if (i == 1) {
                first = temp;
                first.next = first;
                cur = first;
            } else {
                cur.next = temp;
                temp.next = first;
                cur = temp;
            }
        }
    }

    /**
     * 打印环形链表
     * 
     */
    public void display() {
        if (first == null) {
            System.out.println("空链表没有节点");
            return;
        }

        // 定义一个辅助指针 指向头节点
        ListNode curr = first;
        while (true) {
            System.out.printf("结点的编号是 : %d\n", curr.no);
            if (curr.next == first) {
                break;
            }
            curr = curr.next;
        }
    }

    /**
     * 根据用户的输入，计算出节点出环的顺序
     * 
     * @param start 从第几个节点开始数数
     * @param count 数了几次
     * @param nums 初始的节点个数
     */
    public void count(int start, int count, int num) {

        // 数据校验
        // 思路一： 是否是空指针
        // 思路二：开始的节点序号不能小于1，只能是1 <= start <= num
        if (first == null || start < 1 || start > num) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }

        ListNode helper = first;

        // 需要将helper移到头指针的前一个位置
        while (true) {
            if (helper.next == first) {
                break;
            }
            helper = helper.next;
        }

        // 需要将头指针从start位置开始
        for (int i = 0; i < start - 1; i++) {
            first = first.next;
            helper = helper.next;
        }

        // 开始出环
        while (true) {
            if (helper == first) { // 只有一个节点
                break;
            }

            for (int i = 0; i < count - 1; i++) {
                first = first.next;
                helper = helper.next;
            }

            System.out.printf("出环的节点是: %d\n", first.no);
            first = first.next;
            helper.next = first;
        }
        System.out.printf("最后一个留在圈里的节点序号是:%d\n", first.no);
    }

    public static void main(String[] args) {
        CycleSingleLinkedList cll = new CycleSingleLinkedList();
        cll.add(5);
        cll.display();

        cll.count(1, 2, 5);
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