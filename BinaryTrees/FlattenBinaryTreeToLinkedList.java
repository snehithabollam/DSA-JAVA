/**
 * Flatten Binary Tree to Linked List
 *
 * Approach:
 * Process the right subtree first, then the left subtree.
 * Maintain a 'prev' node and connect the current node to it.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * where h = height of the binary tree.
 *
 * Worst Case Space: O(n)
 */
public class FlattenBinaryTreeToLinkedList {

    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Stores the previously processed node
    static TreeNode prev = null;

    /**
     * Flattens the binary tree into a linked list.
     */
    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // Process the right subtree first
        flatten(root.right);

        // Process the left subtree
        flatten(root.left);

        // Connect current node to the previously processed node
        root.right = prev;

        // Left pointer should always be null
        root.left = null;

        // Update previous node
        prev = root;
    }

    /**
     * Prints the flattened tree.
     */
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

        // Flatten the binary tree
        flatten(root);

        // Print the flattened tree
        printFlattenedTree(root);
    }
}