package hashtable;

import lifei.AbsAlgorithmExplain;

public class HashTableDemo extends AbsAlgorithmExplain {

    EmployeeLinkedList[] arrEmployeeLinkedList;

    private int size;

    public HashTableDemo(int size) {
        this.size = size;
        arrEmployeeLinkedList = new EmployeeLinkedList[this.size];
        for (int i = 0; i < arrEmployeeLinkedList.length; i++) {
            arrEmployeeLinkedList[i] = new EmployeeLinkedList();
        }
    }

    public void add(Employee newEmp) {
        int hash = hash(newEmp.id);
        EmployeeLinkedList employeeLinkedList = arrEmployeeLinkedList[hash];
        employeeLinkedList.add(newEmp);
    }

    public void remove(int id) {
        int hash = hash(id);
        EmployeeLinkedList employeeLinkedList = arrEmployeeLinkedList[hash];
        employeeLinkedList.remove(id);
    }

    public void list() {
        for (EmployeeLinkedList employeeLinkedList : arrEmployeeLinkedList) {
            employeeLinkedList.list();
        }
    }

    private int hash(int id) {
        return id % this.size;
    }

    @Override
    protected void extendedIdea() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void basicIdea() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void introduce() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void execute() {

    }

    public static void main(String[] args) {
        HashTableDemo hashTableDemo = new HashTableDemo(5);
        hashTableDemo.add(new Employee(1, "张三"));
        hashTableDemo.add(new Employee(2, "李斯"));
        hashTableDemo.add(new Employee(3, "王二"));
        hashTableDemo.add(new Employee(4, "赵六"));
        hashTableDemo.add(new Employee(5, "Tom"));
        hashTableDemo.add(new Employee(6, "Jerry"));
        hashTableDemo.list();
        System.out.println("*******************");
        hashTableDemo.remove(4);
        hashTableDemo.remove(3);
        hashTableDemo.list();
        System.out.println("*******************");
        hashTableDemo.add(new Employee(11, "John"));
        hashTableDemo.add(new Employee(16, "John"));
        hashTableDemo.list();
        System.out.println("*******************");
        hashTableDemo.remove(11);
        hashTableDemo.list();
        hashTableDemo.remove(16);
        hashTableDemo.list();
    }
}

class EmployeeLinkedList {

    Employee head = null;

    public void add(Employee newEmployee) {
        if (head == null) {
            head = newEmployee;
            return;
        }

        Employee temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }

        temp.next = newEmployee;
    }

    public void remove(int id) {
        if (head == null) {
            System.out.println("这是空链表，无法删除节点");
            return;
        }

        Employee temp = head;
        Employee helper = null;
        while (true) {

            if (temp.id == id) {
                if (helper == null) {
                    head = null;
                } else {
                    helper.next = temp.next;
                }
                break;
            }

            if (temp.next == null) {
                System.out.printf("没有找到员工编号是%d的员工\n", id);
                break;
            }

            helper = temp;
            temp = temp.next;

        }

    }

    public void list() {
        if (head == null) {
            System.out.println("这是空链表");
            return;
        }

        Employee temp = head;

        while (true) {
            System.out.printf("员工编号：%s\t员工姓名：%s\n", temp.id, temp.name);
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
    }
}

class Employee {

    int id;

    String name;

    Employee next;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
        this.next = null;
    }
}
