/**
 * Definition for a binary tree node.
 *
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

class BalancedBinaryTree {

    /**
     * Checks whether the binary tree is height-balanced.
     *
     * A binary tree is balanced if, for every node,
     * the difference between the heights of its left
     * and right subtrees is at most 1.
     */
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    /**
     * Returns the height of the tree.
     *
     * Returns -1 if the subtree is unbalanced.
     */
    private int getHeight(TreeNode root) {

        // Base case: empty tree has height 0.
        if (root == null) {
            return 0;
        }

        // Calculate height of the left subtree.
        int leftHeight = getHeight(root.left);

        // If left subtree is unbalanced, propagate -1.
        if (leftHeight == -1) {
            return -1;
        }

        // Calculate height of the right subtree.
        int rightHeight = getHeight(root.right);

        // If right subtree is unbalanced, propagate -1.
        if (rightHeight == -1) {
            return -1;
        }

        // If height difference is greater than 1,
        // the current subtree is unbalanced.
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return the height of the current subtree.
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

/*
 * Time Complexity: O(N)
 * - Each node is visited only once.
 *
 * Space Complexity: O(H)
 * - H is the height of the binary tree due to recursion.
 * - Worst case: O(N) for a skewed tree.
 * - Best/Balanced case: O(log N).
 */