package lifei.queue;

import java.util.Scanner;

public class CircleArrayQueue {
	// 表示数组最大容量
	private int maxSize;
	// front指向数组的第一个元素，初始值是0
	private int front;
	// rear指向数组的倒数第二个元素，但倒数第一个元素留空，初始值是0
	private int rear;
	// 模拟队列，存储数据
	private int [] array;
	
	public CircleArrayQueue(int arrayMaxSize) {
		maxSize = arrayMaxSize + 1;
		array = new int[maxSize];
	}
	
	/**
	 * 判断队列是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return rear == front;
	}
	
	/**
	 * 判断队列是否已满
	 * @return
	 */
	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}
	
	/**
	 * 返回队列中实际存储的元素个数
	 * @return
	 */
	public int getActualCount() {
		return (rear + maxSize - front) % maxSize;
	}

	/**
	 * 插入一个元素
	 * @param n
	 */
	public void addElement(int n) {
		if(isFull()) {
			throw new RuntimeException("队列已满，无法新增元素");
		}
		array[rear] = n;
		// 使rear永远指向下一个可插入的位置，也就是当前最后一个元素的下一个位置，因为是环形，所以要取模
		rear = (rear + 1) % maxSize;
	}
	
	/**
	 * 删除节点，队列是先进先出
	 * @param args
	 */
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("队列已空，无法删除元素");
		}
		// 由于front指向第一个元素，所以可以分三步实现删除节点
		// 1. 保存front指向的元素到临时变量
		int n = array[front];
		// 2. 重新计算front，但不能简单将front++,因为要考虑front不能越界,所以要取模处理
		front = (front + 1) % maxSize;
		// 3. 返回n
		return n;
	}
	
	/**
	 * 返回队列首元素
	 */
	public int head() {
		if(isEmpty()) {
			throw new RuntimeException("队列已空，无法删除元素");
		}
		return array[front];
	}
	
	/**
	 * 打印队列的所有元素
	 * @param args
	 */
	public void display() {
		if(isEmpty()) {
			throw new RuntimeException("队列已空，没有元素");
		}
		
		for(int i = front; i < front + getActualCount(); i ++) {
			System.out.printf("array[%d] = %d\n", i % maxSize, array[i % maxSize]);
		}
	}
	
	public static void main(String[] args) {
		CircleArrayQueue queue = new CircleArrayQueue(3);
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
					try {
						queue.display();
					}catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 'e':
					scanner.close();
					loop = false;
					break;
				case 'a':
					System.out.println("请输入一个数:");
					int val = scanner.nextInt();
					try {
						queue.addElement(val);
					}catch (Exception e) {
						System.out.println(e.getMessage());
					}
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
						val = queue.head();
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
