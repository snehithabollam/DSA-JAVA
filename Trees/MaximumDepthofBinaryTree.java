public class MaximumDepthofBinaryTree {
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

    /**
     * Returns the maximum depth of a binary tree.
     *
     * Maximum depth is the number of nodes along
     * the longest path from the root to a leaf.
     */
    public int maxDepth(TreeNode root) {

        // Base case: an empty tree has depth 0.
        if (root == null) {
            return 0;
        }

        // Find the depth of the left subtree.
        int leftDepth = maxDepth(root.left);

        // Find the depth of the right subtree.
        int rightDepth = maxDepth(root.right);

        // Current depth = 1 + deeper subtree.
        return 1 + Math.max(leftDepth, rightDepth);
    }
/*
 * Time Complexity: O(N)
 * - Each node is visited exactly once.
 *
 * Space Complexity: O(H)
 * - H is the height of the binary tree due to recursion.
 *
 * Worst Case: O(N)     -> Skewed tree
 * Best Case:  O(log N) -> Balanced tree
 */
}
