package lifei.stack.questions;

import lifei.stack.StackLinkedList;

/**
 * 使用栈实现简单计算器功能 
 * 需要先具体三个小功能: 
 * 1. 判断字符是否是运算符号 
 * 2. 判断两个运算符的优先级高低 
 * 3. 根据给出的预算符和参与计算的两个数值，进行运算并返回结果
 * 
 * 处理步骤： 
 * 1. 通过一个index索引，用来遍历表达式 
 * 2. 如果当前元素是数值，直接入数栈 
 * 3. 如果当前元素是运算符，分几种情况处理 
 *  3.1 如果符号栈为空，则直接入符号栈 
 *  3.2 如果符号栈不为空，则比较当前元素和符号栈栈顶的符号的优先级 
 *      3.2.1 如果小于或等于符号栈栈顶的优先级，则从数栈pop出两个数，从符号栈pop出一个数，进行运算后将运算结果入数栈,然后将当前符号入符号栈
 *      3.2.2 如果当前符号大于符号栈栈顶的有衔接，则直接入符号栈
 * 4. 当扫描结束后，顺序pop出数栈和符号栈的数和符号，并运行
 * 5. 最后在数栈只有一个数值，就是表达式的结果
 * 
 * 遗留问题的解决：
 * 1. 支持了多数位的计算
 * 思路：
 * 1. 拼接数字串
 * 2. 如果索引到了最后,直接压入数栈
 * 3. 如果没到最后，但当前元素是运算符，直接将已拼接的数字串转成Integer压入数栈
 * @author Fei.Li
 *
 */
public class StackCalculator2 {

    public static void main(String[] args) {

        // StackArray numStack = new StackArray(10);
        // StackArray operStack = new StackArray(10);

        StackLinkedList numStack = new StackLinkedList(10);
        StackLinkedList operStack = new StackLinkedList(10);

        String formula = "7*2*2-5+1-5+3-4";

        char ch = ' ';
        int num1, num2;
        int res;
        int oper = 0;
        int index = 0;
        String numeric = "";
        while (true) {
            // 取出计算器表达式的第一个元素
            ch = formula.substring(index, index + 1).charAt(0);

            // 如果是运算符号
            if (isOper(ch)) {
                // 如果栈中不为空
                if (operStack.isEmpty()) {
                    // 直接将符号进栈
                    operStack.push(ch);
                }
                // 如果新符号比栈中符号优先级低
                else if (priority(ch) <= priority(operStack.peek())) {
                    // 取出数 num1 和 num2
                    num1 = numStack.pop();
                    num2 = numStack.pop();
                    // 取出运算符号
                    oper = operStack.pop();
                    // 计算出结果
                    res = calculate(num1, num2, oper);
                    // 再放入栈
                    numStack.push(res);
                    operStack.push(ch);
                } else {
                    operStack.push(ch);
                }

            } else { // 如果是数据，则压入栈中
                numeric += ch;
                // 需要考虑多数位的值,如果遍历到表达式最后一位，无需处理多位数情况
                if (index == formula.length() - 1) {
                    numStack.push(Integer.parseInt(numeric));
                } else {

                    // 如果下一位是符号
                    if (isOper(formula.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(numeric));
                        numeric = "";
                    }
                }
            }
            index++;
            // 判断遍历是否结束
            if (index >= formula.length()) {
                break;
            }

        }

        while (true) {
            // 计算结束可以依据符号栈是否为空，但不能用数栈
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = calculate(num1, num2, oper);
            numStack.push(res);
        }
        System.out.printf("根据表达式%s\t最终结果是 %d", formula, numStack.pop());
    }

    /**
     * 根据运算符号和两个值，返回数学运算结果
     * 
     * @param num1
     * @param num2
     * @param oper
     * @return
     */
    public static int calculate(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
        case '+':
            res = num1 + num2;
            break;
        case '-':
            res = num2 - num1;
            break;
        case '*':
            res = num1 * num2;
            break;
        case '/':
            res = num2 / num1;
            break;
        }
        return res;
    }

    /**
     * 
     * @param oper
     * @return
     */
    public static int priority(int oper) {
        if (oper == '+' || oper == '-') {
            return 100;
        } else if (oper == '*' || oper == '/') {
            return 200;
        } else if (oper == '(' || oper == ')') {
            return 300;
        }
        return -1;
    }

    /**
     * 
     * @param ch
     * @return
     */
    public static boolean isOper(int ch) {
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            return true;
        }

        return false;
    }
}
