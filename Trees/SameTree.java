public class SameTree {
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
     * Checks whether two binary trees are identical.
     *
     * Two trees are the same if:
     * 1. Their corresponding nodes have the same values.
     * 2. Their left subtrees are identical.
     * 3. Their right subtrees are identical.
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // If either tree is empty, both must be empty
        // for the trees to be identical.
        if (p == null || q == null) {
            return p == q;
        }

        // Check current node values and recursively
        // compare the left and right subtrees.
        return (p.val == q.val)
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

/*
 * Time Complexity: O(N)
 * - N is the number of nodes compared.
 * - Each corresponding node is visited at most once.
 *
 * Space Complexity: O(H)
 * - H is the height of the tree due to recursion.
 *
 * Worst Case: O(N)  -> Skewed tree
 * Best/Balanced Case: O(log N)
 */
}
