import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     
 *     TreeNode() {}
 *     
 *     TreeNode(int val) {
 *         this.val = val;
 *     }
 *     
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    /**
     * Performs Level Order Traversal of a Binary Tree.
     *
     * Approach:
     * - Use a Queue to process nodes level by level.
     * - At the beginning of each level, store the current queue size.
     * - Process exactly that many nodes to complete the current level.
     * - Add their children to the queue for the next level.
     *
     * @param root Root node of the binary tree
     * @return List of levels containing node values
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * where n = number of nodes in the binary tree.
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        // If the tree is empty, return an empty list.
        if (root == null) {
            return result;
        }

        // Queue is used for Breadth-First Search (BFS).
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            // Number of nodes present at the current level.
            int levelSize = queue.size();

            List<Integer> currentLevel = new ArrayList<>();

            // Process all nodes of the current level.
            for (int i = 0; i < levelSize; i++) {

                TreeNode currentNode = queue.poll();

                currentLevel.add(currentNode.val);

                // Add left child to the queue.
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                // Add right child to the queue.
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // Add the current level to the result.
            result.add(currentLevel);
        }

        return result;
    }
}