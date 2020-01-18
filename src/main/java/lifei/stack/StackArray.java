package lifei.stack;


public class StackArray {

    private int top;

    private int[] array;

    private int maxSize;

    public StackArray(int maxSize) {
        this.maxSize = maxSize;
        this.array = new int[this.maxSize];
        top = -1;
    }

    /**
     * 判断栈是否满
     * 
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 判断栈是否空
     * 
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 压栈处理
     * 
     * @param val
     */
    public void push(int val) {
        if (isFull()) {
            throw new RuntimeException("栈已经满了，无法再压栈");
        }

        top++;
        array[top] = val;
    }

    /**
     * 出栈处理
     * 
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈已经空了，无法再出栈");
        }
        int val = array[top];
        array[top] = 0;
        top--;
        return val;
    }

    /**
     * 打印栈，从栈顶到栈底依次打印
     * 
     */
    public void printStack() {
        if (isEmpty()) {
            System.out.println("无法打印空栈");
        }

        for (int i = top; i >= 0; i--) {
            System.out.printf("栈元素是 %d\n", array[i]);
        }
    }

    /**
     * 仅读取栈顶的值
     * 
     * @param args
     * @throws Exception
     */
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈已空，无元素");
        }

        return array[top];
    }

    public static void main(String[] args) throws Exception {
        StackArray stack = new StackArray(5);

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
