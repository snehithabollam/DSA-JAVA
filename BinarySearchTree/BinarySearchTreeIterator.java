import java.util.Stack;
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

/**
 * BST Iterator
 *
 * Returns the nodes of a Binary Search Tree in ascending order.
 *
 * Approach:
 * Use a stack to simulate the recursive inorder traversal.
 *
 * Inorder traversal of a BST:
 * Left -> Root -> Right
 * produces values in sorted order.
 */
class BSTIterator {

    private final Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
       stack = new Stack<>();
        pushAllLeft(root);
    }

    /**
     * Returns the next smallest value in the BST.
     */
    public int next() {
        TreeNode current = stack.pop();

        // After visiting the current node,
        // process its right subtree.
        pushAllLeft(current.right);

        return current.val;
    }

    /**
     * Returns true if there are more nodes to visit.
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * Push all left nodes onto the stack.
     */
    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}