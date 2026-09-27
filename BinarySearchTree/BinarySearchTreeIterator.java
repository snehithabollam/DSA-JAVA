import java.util.Stack;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * BST Iterator
 *
 * Returns the nodes of a Binary Search Tree in ascending order.
 *
 * Approach:
 * Use a stack to simulate the recursive inorder traversal.
 *
 * Inorder traversal of a BST:
 * Left -> Root -> Right
 * produces values in sorted order.
 */
class BSTIterator {

    private final Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
       stack = new Stack<>();
        pushAllLeft(root);
    }

    /**
     * Returns the next smallest value in the BST.
     */
    public int next() {
        TreeNode current = stack.pop();

        // After visiting the current node,
        // process its right subtree.
        pushAllLeft(current.right);

        return current.val;
    }

    /**
     * Returns true if there are more nodes to visit.
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * Push all left nodes onto the stack.
     */
    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
// another approach
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *
 *     TreeNode() {}
 *
 *     TreeNode(int val) {
 *         this.val = val;
 *     }
 *
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    /**
     * Searches for a given value in a Binary Search Tree (BST).
     *
     * Approach:
     * - If the current node is null, the value is not present.
     * - If the current node contains the target value, return the node.
     * - If val is smaller than the current node's value,
     *   search in the left subtree.
     * - Otherwise, search in the right subtree.
     *
     * Time Complexity:
     * - Average case: O(log n) for a balanced BST
     * - Worst case: O(n) for a skewed BST
     *
     * Space Complexity:
     * - Average case: O(log n) due to recursion stack
     * - Worst case: O(n) for a skewed BST
     *
     *  root The root of the Binary Search Tree.
     *  val The value to search for.
     *  The node containing val, or null if not found.
     */
    public TreeNode searchBST(TreeNode root, int val) {

        // Base case: tree is empty or target value is found
        if (root == null || root.val == val) {
            return root;
        }

        // Search in the left subtree
        if (val < root.val) {
            return searchBST(root.left, val);
        }

        // Search in the right subtree
        return searchBST(root.right, val);
    }
}
