package lifei.queue;

import java.io.Reader;
import java.util.Scanner;

public class ArrayQueue {

	private int maxSize;
	private int front;
	private int rear;
	private int array[];
	
	public ArrayQueue(int size) {
		this.maxSize = size;
		this.array = new int[this.maxSize];
		front = -1;
		rear = -1;
	}
	
	public boolean isFull() {
		return rear == maxSize - 1;
	}
	
	public boolean isEmpty() {
		if(front == rear)
			reset();
		return front == rear;
	}
	
	public void add(int val) {
		if(isFull()) {
			System.out.println("队列已满，无法再增加元素到队列");
			return;
		}
		rear++;
		array[rear] = val;
	}
	
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("队列已空，没有任何数据");
		}
		front++;
		return array[front];
	}
	
	private void reset() {
		front = -1;
		rear = -1;
	}
	
	public int peak() {
		if(isEmpty()) {
			throw new RuntimeException("队列已空，没有任何数据");
		}
		return array[front+1];
	}
	
	public void traverse() {
		if(isEmpty()) {
			System.out.println("队列已空，没有任何数据");
			return;
		}
		for(int i = 0; i < array.length; i++) {
			System.out.printf("array[%d] = %d\r", i, array[i]);
		}
	}
	
	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(3);
		char key = ' '; //接收用户输入
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		// 输出菜单选项
		while(loop) {
			System.out.println("s(show):显示队列");
			System.out.println("e(exit):退出程序");
			System.out.println("a(add):添加数据到队列");
			System.out.println("g(get):从队列取出数据");
			System.out.println("h(head):查看队列头的数据");
			key = scanner.next().charAt(0);
			switch(key) {
				case 's':
					queue.traverse();
					break;
				case 'e':
					scanner.close();
					loop = false;
					break;
				case 'a':
					System.out.println("请输入一个数:");
					int val = scanner.nextInt();
					queue.add(val);
					break;
				case 'g':
					try {
						val = queue.pop();
						System.out.printf("取出的数据是%d\n", val);
					}catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 'h':
					try {
						val = queue.peak();
						System.out.printf("队列头的数据是%d\n", val);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					
					break;
				default:
					break;
			}
		}
		System.out.println("程序退出！");
		
	}
}
