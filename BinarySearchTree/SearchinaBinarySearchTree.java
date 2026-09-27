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
public class SearchinaBinarySearchTree {
    /**
     * Searches for a node with the given value in a Binary Search Tree.
     *
     * Approach:
     * - If the current node is null, the value does not exist.
     * - If the current node contains the target value, return it.
     * - If the target is smaller, search the left subtree.
     * - If the target is larger, search the right subtree.
     *
     * Time Complexity:
     * - Average case: O(log n) for a balanced BST
     * - Worst case: O(n) for a skewed BST
     *
     * Space Complexity:
     * - O(1) auxiliary space since the search is iterative.
     *
     *  root The root of the Binary Search Tree.
     *  val The value to search for.
     * The node containing val, or null if it is not found.
     */
    public TreeNode searchBST(TreeNode root, int val) {

        while (root != null) {

            // Target value found
            if (root.val == val) {
                return root;
            }

            // Move to the appropriate subtree
            if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        // Value not found in the BST
        return null;
    }
}
