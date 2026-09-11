/**
 * Count Nodes Equal to Average of Subtree
 *
 * Approach:
 * Postorder DFS
 *
 * For every node, calculate:
 * 1. Sum of all nodes in its subtree
 * 2. Number of nodes in its subtree
 *
 * Then check whether:
 * node value == subtree average
 */

public class CountNodesEqualtoAverageofSubtree {

    // Binary Tree Node
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

    private int count = 0;

    public int averageOfSubtree(TreeNode root) {
        count = 0;
        dfs(root);
        return count;
    }

    // Returns {sum of subtree, number of nodes in subtree}
    private int[] dfs(TreeNode root) {

        // Base case
        if (root == null) {
            return new int[]{0, 0};
        }

        // Process left subtree
        int[] left = dfs(root.left);

        // Process right subtree
        int[] right = dfs(root.right);

        // Calculate subtree sum
        int sum = left[0] + right[0] + root.val;

        // Calculate number of nodes
        int nodes = left[1] + right[1] + 1;

        // Check if node value equals subtree average
        if (root.val == sum / nodes) {
            count++;
        }

        return new int[]{sum, nodes};
    }

    // Time Complexity: O(n)
    // Space Complexity: O(h)
    // n = number of nodes
    // h = height of the binary tree

    public static void main(String[] args) {

        /*
                 4
                / \
               8   5
              / \   \
             0   1   6
        */

        TreeNode root = new TreeNode(
            4,
            new TreeNode(
                8,
                new TreeNode(0),
                new TreeNode(1)
            ),
            new TreeNode(
                5,
                null,
                new TreeNode(6)
            )
        );

        CountNodesEqualtoAverageofSubtree solution =
                new CountNodesEqualtoAverageofSubtree();

        System.out.println(solution.averageOfSubtree(root));
    }
}