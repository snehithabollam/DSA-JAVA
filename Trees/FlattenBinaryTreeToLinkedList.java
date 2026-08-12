import java.util.*;

public class FlattenBinaryTreeToLinkedList {

    /*
     * Problem: Flatten Binary Tree to Linked List
     *
     * Approach:
     * Process the right subtree first, then the left subtree.
     * Maintain a 'prev' node and connect the current node to it.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     * where h = height of the binary tree.
     * Worst case space: O(n)
     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static TreeNode prev = null;

    public static void flatten(TreeNode root) {

        if (root == null)
            return;

        // Process right subtree first
        flatten(root.right);

        // Process left subtree
        flatten(root.left);

        // Connect current node to previously processed node
        root.right = prev;

        // Left pointer should be null
        root.left = null;

        prev = root;
    }

    public static void printFlattenedTree(TreeNode root) {

        while (root != null) {
            System.out.print(root.val + " -> ");
            root = root.right;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        /*
                 1
                / \
               2   5
              / \   \
             3   4   6
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(6);

        flatten(root);

        printFlattenedTree(root);
    }
}