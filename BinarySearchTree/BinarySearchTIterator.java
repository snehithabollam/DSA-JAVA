import java.util.*;

/**
 * LeetCode 173: Binary Search Tree Iterator
 *
 * Approach:
 * Use a stack to simulate inorder traversal of the BST.
 *
 * Inorder Traversal:
 * Left -> Root -> Right
 *
 * The smallest element is kept at the top of the stack.
 * After returning a node, we process its right subtree.
 *
 * Time Complexity:
 * - next(): O(h) amortized O(1)
 * - hasNext(): O(1)
 *
 * Space Complexity: O(h)
 *
 * where h = height of the BST.
 */
public class BinarySearchTIterator {

    private final Deque<TreeNode> stack = new ArrayDeque<>();

    public BinarySearchTIterator(TreeNode root) {
        pushAll(root);
    }

    /**
     * Returns the next smallest element.
     */
    public int next() {
        TreeNode current = stack.pop();

        // Add the leftmost path of the right subtree.
        pushAll(current.right);

        return current.val;
    }

    /**
     * Returns true if there are more elements.
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * Push all nodes along the left path.
     */
    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

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
}
