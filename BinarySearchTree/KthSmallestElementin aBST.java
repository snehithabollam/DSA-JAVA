import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node.
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

class Solution {

    private final List<Integer> result = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return result.get(k - 1);
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        // Inorder traversal:
        // Left -> Root -> Right
        inorder(node.left);

        result.add(node.val);

        inorder(node.right);
    }

    /*
     * Time Complexity: O(n)
     * - We visit every node exactly once.
     *
     * Space Complexity: O(n)
     * - result stores all n node values -> O(n)
     * - Recursion stack -> O(h), where h is the tree height.
     * - Overall: O(n + h) = O(n)
     *
     * Balanced BST:
     *   h = O(log n)
     *   Space = O(n)
     *
     * Skewed BST:
     *   h = O(n)
     *   Space = O(n)
     */
}