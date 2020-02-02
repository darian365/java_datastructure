package zhangjie.linkedlist;

public class Josepfu {

	public static void main(String[] args) {
		// 测试环形链表 和 遍历
		CircleSingleList circleSingleList = new CircleSingleList();
		circleSingleList.addBoy(5);
		circleSingleList.showboy();
		
		//测试一把小孩出圈是否正确
		circleSingleList.counBoy(1, 2, 5);
	}
}

// 创建一个环形的单向链表
class CircleSingleList {
	// 创建一个first节点 当前没有编号
	private Boy first = null;

	// 添加节点 构建成环形单向链表
	public void addBoy(int nums) {
		if (nums < 1) {
			System.out.println("nums的值不正确");
			return;
		}
		// 使用for循环来创建我们的环形链表
		Boy curBoy = null;// 辅助指针 帮助构建环形链表

		for (int i = 1; i <= nums; i++) {
			// 根据编号 创建节点
			Boy boy = new Boy(i);
			if (i == 1) {
				first = boy;
				first.setNext(first);
				curBoy = first;
			} else {
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy = boy;
			}
		}
	}

	// 遍历当前链表
	public void showboy() {
		if (first == null) {
			System.out.println("没有小孩参加游戏~~");
			return;
		}
		Boy curBoy = first;
		while (true) {
			System.out.printf("小孩的编号是 %d \n", curBoy.getNo());
			if (curBoy.getNext() == first) {// 说明已经遍历完毕 退出
				break;
			}
			curBoy = curBoy.getNext();// curBoy后移
		}
	}

	// 根据用户的输入，计算出小孩出圈的顺序
	/**
	 * 
	 * @param startNo
	 *            表示从第几个小孩开始数数
	 * @param countNum
	 *            表示树几下
	 * 
	 * @param nums
	 *            表示最初有多少小孩在圈中
	 */
	public void counBoy(int startNo, int countNum, int nums) {
		if (first == null || startNo < 1 || startNo > nums) {
			System.out.println("参数输入有误，请重新输入");
			return;
		}
		// 创建要给辅助指针，帮助完成小孩出圈
		Boy helper = first;
		// 需要创建一个辅助指针helper，事先应该指向环形链表的最后这个节点
		while (true) {
			if (helper.getNext() == first) {// 说明helper指向最后小孩节点
				break;

			}
			helper = helper.getNext();
		}
		//小孩报数前，先让first 和 helper 移动startNo-1次
		for(int j =0;j<startNo-1; j++) {
			first = first.getNext();
			helper = helper.getNext();
		}
		//当小孩报数时 让first和helper 指针同时的移动countNum-1次，然后出圈
		//这里是一个循环操作，直到圈中只有一个节点
		while(true) {
			if(helper == first) {
				break;
			}
			//让first和helper 指针同时的移动countNum-1次
			for(int j = 0; j < countNum -1; j++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			//这时first所在的节点，就是要出圈的小孩节点
			System.out.printf("小孩%d出圈\n", first.getNo());
			//让first指向的小孩出圈
			first = first.getNext();
			helper.setNext(first);//这句话相等于 helper= helper.getNext();
			
		}
		System.out.printf("最后留在圈内的小孩编号 %d \n",first.getNo());
	}

}

// 创建一个类，表示一个节点
class Boy {
	private int no;// 编号
	private Boy next;// 指向下一个节点

	public Boy(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

}
