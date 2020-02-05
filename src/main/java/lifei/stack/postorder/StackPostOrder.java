package lifei.stack.postorder;

import java.util.Stack;

/**
 * 中序转后序
 * 
 * @author Fei.Li
 */
public class StackPostOrder {

    public static void main(String[] args) {

        // 中缀表达式
        String inOrder = "1+((2+3)*4)-5";

        // 1. 初始化两个栈, 运算符栈s1和储存临时结果的s2
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        // 2. 从左至右扫描中缀表达式
        for (char c : inOrder.toCharArray()) {
            // 3. 遇到数值，将其压倒s2
            if (isNumber(c)) {
                s2.push(c);

                // 4. 遇到运算符，比较其与s1栈顶运算符的优先级
            }else if (isOperator(c)) {
                // 4.1 如果s1为空，或栈顶运算符是(,则直接将该运算符压栈
                if (s1.empty() || s1.peek() == '(') {
                    s1.push(c);
                }
                // 4.2 否则，若优先级比栈顶运算符高，也将运算符压入s1
                else if (priority(c) > priority(s1.peek())) {
                    s1.push(c);
                }
                // 4.3 否则，将s1栈顶的运算符弹出并压入s2中，再次转到4.1与s1中新的栈顶运算符相比较
                else {
                    s2.push(s1.pop());
                }
            } // 5. 遇到括号时：
              // 5.1 如果是左括号(,则直接压入s1
            else if (isLeftParenthesis(c)) {
                s1.push(c);
            }
            // 5.2 如果是右括号),则依次弹出s1栈顶的运算符，并压入s2,直到 遇到左括号为止，此时将这一对括号丢弃
            else if (isRightParenthesis(c)) {

                while (s1.peek() != ')') {
                    s2.push(s1.pop());
                }

                s1.pop();
            }
            // 6. 重复步骤2到5，直到扫描结束
        }

        // 7. 将s1中剩余的运算符依次弹出并压入s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        // 8. 依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
        StringBuilder postOrder = new StringBuilder();
        while (s1.isEmpty()) {
            postOrder.append(s1.pop());
        }

        System.out.println(postOrder.toString());
    }

    /**
     * 判断是否数值
     * 
     * @param c
     * @return
     */
    public static boolean isNumber(char c) {
        return c >= 48 && c <= 57;
    }

    /**
     * 判断是否是运算符
     * 
     * @param c
     * @return
     */
    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    /**
     * 返回运算符的优先级
     * 
     * @param c
     * @return
     */
    public static int priority(char c) {
        int priority = 0;
        switch (c) {
        case '+':
            priority = 100;
            break;
        case '-':
            priority = 100;
            break;
        case '*':
            priority = 200;
            break;
        case '/':
            priority = 200;
            break;
        }
        return priority;
    }

    /**
     * 如果是左括号
     * 
     * @param c
     * @return
     */
    public static boolean isLeftParenthesis(char c) {
        return c == '(';
    }

    public static boolean isRightParenthesis(char c) {
        return c == ')';
    }
}
