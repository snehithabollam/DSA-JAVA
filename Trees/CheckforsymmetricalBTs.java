/**
 * Check whether a binary tree is symmetric.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 *
 * n = number of nodes
 * h = height of the binary tree
 */

public class CheckforsymmetricalBTs{

    // Definition of a binary tree node
    static class TreeNode {
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

    // Checks whether the tree is symmetric
    public static boolean isSymmetric(TreeNode root) {

        // An empty tree is symmetric
        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    // Checks whether two subtrees are mirror images
    private static boolean isMirror(TreeNode left, TreeNode right) {

        // Both nodes are null
        if (left == null && right == null) {
            return true;
        }

        // Only one node is null
        if (left == null || right == null) {
            return false;
        }

        // Values are different
        if (left.val != right.val) {
            return false;
        }

        // Compare opposite sides
        return isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }

    public static void main(String[] args) {

        /*
                 1
                / \
               2   2
              / \ / \
             3  4 4  3

             This tree is symmetric.
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println("Is the tree symmetric? "
                + isSymmetric(root));
    }
}