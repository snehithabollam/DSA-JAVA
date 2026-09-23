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

class Solution {

    /**
     * Checks whether the binary tree is height-balanced.
     *
     * A binary tree is balanced if the difference between
     * the heights of the left and right subtrees is at most 1
     * for every node.
     */
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    /**
     * Returns the height of the subtree.
     *
     * Returns -1 if the subtree is unbalanced.
     */
    private int getHeight(TreeNode root) {

        // Empty tree has height 0.
        if (root == null) {
            return 0;
        }

        // Find height of left subtree.
        int leftHeight = getHeight(root.left);

        // Left subtree is unbalanced.
        if (leftHeight == -1) {
            return -1;
        }

        // Find height of right subtree.
        int rightHeight = getHeight(root.right);

        // Right subtree is unbalanced.
        if (rightHeight == -1) {
            return -1;
        }

        // Check balance condition.
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return height of current subtree.
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

/*
 * Time Complexity: O(N)
 * Each node is visited only once.
 *
 * Space Complexity: O(H)
 * H = height of the binary tree.
 *
 * Worst Case: O(N)  -> Skewed tree
 * Best Case:  O(log N) -> Balanced tree
 */