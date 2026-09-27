/**
 * Maximum Path Sum in a Binary Tree
 *
 * A path can start and end at any node in the tree.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 *
 * n = number of nodes
 * h = height of the binary tree
 */

public class Maximumpathsum {

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

    /**
     * Finds the maximum path sum in the binary tree.
     */
    public int maxPathSum(TreeNode root) {

        // Stores the maximum path sum found so far.
        int[] maxSum = {Integer.MIN_VALUE};

        maxPathDown(root, maxSum);

        return maxSum[0];
    }

    /**
     * Returns the maximum path sum that can be extended
     * from the current node to its parent.
     */
    private int maxPathDown(TreeNode node, int[] maxSum) {

        // Null node contributes nothing.
        if (node == null) {
            return 0;
        }

        // Ignore negative contribution from left subtree.
        int leftGain = Math.max(0, maxPathDown(node.left, maxSum));

        // Ignore negative contribution from right subtree.
        int rightGain = Math.max(0, maxPathDown(node.right, maxSum));

        // Path passing through the current node.
        int currentPathSum = leftGain + node.val + rightGain;

        // Update the maximum path sum.
        maxSum[0] = Math.max(maxSum[0], currentPathSum);

        // Return the maximum one-sided path to the parent.
        return Math.max(leftGain, rightGain) + node.val;
    }

    public static void main(String[] args) {

        /*
                 1
                / \
               2   3
              / \
             4   5

             Maximum Path:
             4 -> 2 -> 1 -> 3

             Maximum Sum = 10
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Maximumpathsum solution = new Maximumpathsum();

        System.out.println("Maximum Path Sum: "
                + solution.maxPathSum(root));
    }
}