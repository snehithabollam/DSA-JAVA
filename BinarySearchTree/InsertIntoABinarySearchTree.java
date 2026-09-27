
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     
 *     TreeNode() {}
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

public class InsertIntoABinarySearchTree {

    /**
     * Inserts a new value into a Binary Search Tree (BST).
     *
     * @param root Root of the BST
     * @param val  Value to be inserted
     * @return Root of the updated BST
     *
     * Time Complexity:
     *   Average Case: O(log n)
     *   Worst Case:   O(n)
     *
     * Space Complexity:
     *   Average Case: O(log n) - recursion stack
     *   Worst Case:   O(n)    - skewed tree
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {

        // If the current position is empty,
        // create and return a new node.
        if (root == null) {
            return new TreeNode(val);
        }

        // If value is smaller, insert into the left subtree.
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }

        // If value is greater or equal, insert into the right subtree.
        else {
            root.right = insertIntoBST(root.right, val);
        }

        // Return the root of the updated BST.
        return root;
    }
}
