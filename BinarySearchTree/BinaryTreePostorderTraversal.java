    import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Postorder Traversal
 *
 * Traversal Order:
 * Left -> Right -> Root
 *
 * Example:
 *        1
 *       / \
 *      2   3
 *
 * Output: [2, 3, 1]
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

public class BinaryTreePostorderTraversal {

    private final List<Integer> result = new ArrayList<>();

    /**
     * Performs postorder traversal of a binary tree.
     *
     * @param root Root of the binary tree
     * @return List containing postorder traversal
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return result;
    }

    /**
     * Recursive postorder traversal:
     * Left -> Right -> Root
     */
    private void postorder(TreeNode root) {

        // Base case
        if (root == null) {
            return;
        }

        // Traverse left subtree
        postorder(root.left);

        // Traverse right subtree
        postorder(root.right);

        // Visit root
        result.add(root.val);
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

