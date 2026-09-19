import java.util.*;

/**
 * Binary Tree Level Order Traversal
 *
 * Approach:
 * Use Breadth-First Search (BFS) with a Queue.
 * Process the tree level by level.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * n = number of nodes in the binary tree.
 */
public class LevelOrderTraversal {

    // Definition of a Binary Tree Node
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

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        // If tree is empty
        if (root == null) {
            return result;
        }

        // Queue for BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            // Number of nodes at current level
            int levelSize = queue.size();

            List<Integer> currentLevel = new ArrayList<>();

            // Process current level
            for (int i = 0; i < levelSize; i++) {

                TreeNode currentNode = queue.poll();

                currentLevel.add(currentNode.val);

                // Add left child
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                // Add right child
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            result.add(currentLevel);
        }

        return result;
    }

    public static void main(String[] args) {

        /*
                 3
                / \
               9  20
                  / \
                 15  7
        */

        TreeNode root = new TreeNode(
            3,
            new TreeNode(9),
            new TreeNode(
                20,
                new TreeNode(15),
                new TreeNode(7)
            )
        );

        List<List<Integer>> result = levelOrder(root);

        System.out.println(result);
    }
}