public class CountCompleteTreeNodes {

    /*
     * Problem: Count Complete Tree Nodes
     *
     * Approach:
     * For a complete binary tree, calculate the height of the
     * leftmost path and the rightmost path.
     *
     * If both heights are equal, the tree is a perfect binary tree.
     * Number of nodes = 2^(height + 1) - 1
     *
     * Otherwise, recursively count nodes in the left and right
     * subtrees.
     *
     * Time Complexity: O(log^2 n)
     * Space Complexity: O(log n)
     * where n = number of nodes.
     */

    // Definition of Binary Tree Node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int countNodes(TreeNode root) {

        if (root == null)
            return 0;

        int left = getLeftHeight(root.left);
        int right = getRightHeight(root.right);

        // Perfect binary tree
        if (left == right)
            return (1 << (left + 1)) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Calculate leftmost height
    public static int getLeftHeight(TreeNode root) {

        int count = 0;

        while (root != null) {
            count++;
            root = root.left;
        }

        return count;
    }

    // Calculate rightmost height
    public static int getRightHeight(TreeNode root) {

        int count = 0;

        while (root != null) {
            count++;
            root = root.right;
        }

        return count;
    }

    public static void main(String[] args) {

        /*
                 1
                / \
               2   3
              / \  /
             4  5 6

        Number of nodes = 6
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);

        int result = countNodes(root);

        System.out.println("Number of nodes: " + result);
    }
}