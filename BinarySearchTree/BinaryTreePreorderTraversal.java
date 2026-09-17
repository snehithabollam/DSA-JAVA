import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Preorder Traversal
 *
 * Traversal Order:
 * Root -> Left -> Right
 *
 * Example:
 *        1
 *       / \
 *      2   3
 *
 * Output: [1, 2, 3]
 */

// Definition of a Binary Tree Node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreePreorderTraversal {

    private final List<Integer> result = new ArrayList<>();

    /**
     * Performs preorder traversal.
     *
     * @param root Root of the binary tree
     * @return Preorder traversal list
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return result;
    }

    /**
     * Recursive preorder traversal:
     * Root -> Left -> Right
     */
    private void preorder(TreeNode root) {

        // Base case
        if (root == null) {
            return;
        }

        // Visit root
        result.add(root.val);

        // Traverse left subtree
        preorder(root.left);

        // Traverse right subtree
        preorder(root.right);
    }
}

/*
 * Time Complexity: O(n)
 * - Each node is visited exactly once.
 *
 * Auxiliary Space: O(h)
 * - h = height of the binary tree.
 * - Balanced tree: O(log n)
 * - Skewed tree: O(n)
 *
 * Output Space: O(n)
 * - Result list stores all n nodes.
 *
 * Overall Space Complexity: O(n)
 * - Including the output list.
 */