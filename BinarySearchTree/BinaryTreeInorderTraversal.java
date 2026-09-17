import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Inorder Traversal
 *
 * Traversal Order:
 * Left -> Root -> Right
 *
 * Example:
 *        1
 *       / \
 *      2   3
 *
 * Output: [2, 1, 3]
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

public class BinaryTreeInorderTraversal {

    private final List<Integer> result = new ArrayList<>();

    /**
     * Performs inorder traversal of a binary tree.
     *
     * @param root Root of the binary tree
     * @return List containing inorder traversal
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return result;
    }

    /**
     * Recursive inorder traversal:
     * Left -> Root -> Right
     */
    private void inorder(TreeNode root) {

        // Base case
        if (root == null) {
            return;
        }

        // Traverse left subtree
        inorder(root.left);

        // Visit root
        result.add(root.val);

        // Traverse right subtree
        inorder(root.right);
    }
}

/*
 * Time Complexity: O(n)
 * - Every node is visited exactly once.
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