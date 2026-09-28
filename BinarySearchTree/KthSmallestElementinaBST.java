import java.util.*;

/**
 * LeetCode 230: Kth Smallest Element in a BST
 *
 * Approach:
 * Inorder traversal of a Binary Search Tree visits nodes
 * in ascending order.
 *
 * Therefore, the kth element in the inorder traversal
 * is the kth smallest element.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class KthSmallestElementinaBST {

    /**
     * Definition for a binary tree node.
     */
    static class TreeNode {
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

    private final List<Integer> inorderList = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return inorderList.get(k - 1);
    }

    /**
     * Inorder Traversal:
     * Left -> Root -> Right
     */
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        inorderList.add(root.val);
        inorder(root.right);
    }
}