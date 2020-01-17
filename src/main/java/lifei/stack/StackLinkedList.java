package lifei.stack;


public class StackLinkedList {

    private ListNode head;

    private ListNode helper;

    private int maxSize;

    private int top;

    public StackLinkedList(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;
        this.head = new ListNode(-1);
        this.helper = null;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 压栈
     * 
     * @param val
     */
    public void push(int val) {
        if (isFull()) {
            throw new RuntimeException("栈已经满了，无法继续压栈");
        }

        ListNode temp = new ListNode(val);
        if (helper == null) {
            helper = temp;
            head.next = helper;
        } else {
            ListNode next = helper.next;
            temp.next = helper;
            head.next = temp;
            helper = temp;
        }

        top++;
    }

    /**
     * 出栈
     * 
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈已经空了，无法继续出栈");
        }

        int val = helper.data;
        head.next = helper.next;
        helper = helper.next;
        top--;
        return val;
    }

    /**
     * 打印栈
     */
    public void printStack() {
        if (isEmpty()) {
            throw new RuntimeException("栈已经空了，无法打印栈");
        }

        ListNode temp = helper;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws Exception {
        StackLinkedList stack = new StackLinkedList(5);

        for (int i = 1; i < 6; i++) {
            try {
                stack.push(i);
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }

        stack.printStack();

        System.out.println("开始出栈============");

        for (int i = 1; i < 5; i++) {
            try {
                System.out.printf("出栈的元素是 %d\n", stack.pop());

            } catch (Exception e) {
                stack.printStack();
                throw new Exception(e.getMessage());
            }
        }
        stack.printStack();
    }
}

class ListNode {

    public int data;

    public ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "[data=" + data + "]";
    }
}
