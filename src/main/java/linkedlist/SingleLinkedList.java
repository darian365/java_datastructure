package linkedlist;


public class SingleLinkedList {

    private Node head = new Node(0, "");

    /**
     * 
     * 添加节点到单向链表 
     * 思路：当不考虑编号顺序时， 
     *一， 找到当前链表的最后一个节点，
     *二， 将最后一个节点的next指向x新的节点
     **/
    public void add(Node node) {
        // coz head节点是固定的，所以我们需要一个辅助节点从head开始遍历
        Node temp = head;
        
        while(true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        // temp就是最后一个节点，temp.next是null
        temp.next = node;
    }

    /**
     * 顺序添加节点到单向链表中
     * 思路：
     * 一，需要比较节点的序号大小
     * 二，将新节点放到第一个比新节点序号大的位置
     * @param node
     */
    public void addByOrder(Node node) {
        // coz 需要一个辅助指针从头位置开始找插入到位置
        Node temp = head;

        // coz 需要temp位于要插入位置的前一个节点
        // if 已经存在序号，那么将不插入新节点
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.num > node.num) {
                break;
            } else if (temp.next.num == node.num) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (!flag) {
            node.next = temp.next;
            temp.next = node;
        } else {
            System.out.printf("链表中存在序号是%d\n", node.num);
        }
    }

    /**
     * 更新节点
     * 思路：
     * 一，通过遍历并比较序号找到要更新的节点
     * 二，将要更新节点的值更新为新节点的值
     * @param node
     */
    public void update(Node node) {
        // 需要一个辅助指针从头指针开始遍历
        Node temp = head;

        // 如果节点存在，flag会被set to be true
        boolean flag = false;
        
        while (true) {
            // 遍历到了最后一个节点
            if (temp.next == null) {
                break;
            }
            // 找到了要更新的节点
            if (temp.next.num == node.num) {
                flag = true;
                break;
            }
            // 没到最后一个节点，且没有找到要更新的节点
            temp = temp.next;
        }
        if (flag) {
            temp.next.data = node.data;
        } else {
            System.out.printf("无法更新，因为没有找到序号是%d的节点\n", node.num);
        }
    }

    public void remove(int num) {
        Node temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.num == num) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("无法删除，因为没有找到序号是%d的节点\n", num);
        }
    }

    public void list() {
        if (head.next == null) {
            System.out.println("这是一个空的单向链表");
            return;
        }
        Node temp = head.next;
        System.out.println("单向链表的元素是：");
        while(true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        Node n1 = new Node(1, "杰伦");
        Node n2 = new Node(2, "华健");
        Node n3 = new Node(3, "志玲");
        Node n4 = new Node(4, "英九");

        SingleLinkedList sll = new SingleLinkedList();
        sll.add(n2);
        sll.add(n4);
        sll.add(n3);
        sll.add(n1);

        sll.list();

        System.out.println("顺序添加节点开始 ：");
        sll = new SingleLinkedList();
        sll.addByOrder(n2);
        sll.addByOrder(n4);
        sll.addByOrder(n3);
        sll.addByOrder(n1);

        sll.list();

        System.out.println("更新节点开始 ：");
        sll.update(new Node(2, "建华"));
        sll.update(new Node(5, "建华~~"));
        sll.list();

        System.out.println("删除节点开始 ：");
        sll.remove(3);
        sll.remove(1);
        sll.remove(4);
        sll.remove(2);
        sll.list();

        System.out.println("删除节点开始 ：");
        sll.remove(3);
        sll.list();

    }
}

class Node {

    public int num;

    public String data;

    public Node next;

    public Node(int num, String data) {
        this.num = num;
        this.data = data;
        this.next = null;
    }

    public String toString() {
        return "Node [num=" + num + ", data=" + data + "]";
    }

}