package lifei.binarysearchtree;

import java.util.Scanner;

public class BinarySearchTree {

    // define the root node
    private TreeNode root;

    // define the count of searching
    private int iterations;

    public BinarySearchTree() {
    }

    /**
     * insert integer to the tree and it will be inserted as a left node if val
     * is less than value of current parent node, otherwise right sub node will
     * be inserted
     * 
     * @param parentNode
     * @param val
     * @return
     */
    public TreeNode insert(TreeNode parentNode, int val) {
        if (parentNode == null) {
            parentNode = new TreeNode(val);
            return parentNode;
        }

        if (val < parentNode.val) {
            parentNode.left = insert(parentNode.left, val);
        } else if (val > parentNode.val) {
            parentNode.right = insert(parentNode.right, val);
        }

        return parentNode;
    }

    /**
     * return the root node
     * 
     * @return
     */
    public TreeNode getRoot() {
        return root;
    }

    /**
     * search a value from the binary search tree, left sub node will be the
     * next one to be searched if searchValue is less than value of current
     * parent node, otherwise right sub node will be searched
     * 
     * @param parentNode
     * @param searchValue
     * @return
     */
    public TreeNode binarySearch(TreeNode parentNode, int searchValue) {
        if (parentNode == null) {
            return parentNode;
        }

        iterations++;

        if (parentNode.val == searchValue) {
            System.out.printf("The searchValue %d was found.\n", searchValue);
            System.out.printf("Found search value in: %d iterations", iterations);
        } else if (searchValue < parentNode.val) {
            parentNode.left = binarySearch(parentNode.left, searchValue);
        } else {
            parentNode.right = binarySearch(parentNode.right, searchValue);
        }

        return parentNode;
    }

    /**
     * construct the binary search tree with given data
     * 
     * @param arr
     */
    private void init(String[] arr) {
        root = new TreeNode(Integer.parseInt(arr[0]));

        for (int i = 1; i < arr.length; i++) {
            insert(root, Integer.parseInt(arr[i]));
        }
    }

    public static void main(String[] args) {
        System.out.println(
                "Please input multiple unique integers delimited by space : (i.e. 10 5 12 3 1 13 7 2 4 14 9 8 6 11)");
        Scanner scanner = null;
        int minLenth = 0;
        scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");

        BinarySearchTree bst = new BinarySearchTree();

        bst.init(arr);

        System.out.println("Please input the search value : (i.e. 9)");
        scanner = new Scanner(System.in);

        // this method will let us know the result about the searching
        bst.binarySearch(bst.getRoot(), scanner.nextInt());
    }

}

class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}