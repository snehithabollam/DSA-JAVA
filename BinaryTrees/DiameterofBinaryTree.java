//import javax.swing.tree.TreeNode;

   /**
 * Diameter of a Binary Tree
 *
 * The diameter is the longest path between any two nodes
 * in the binary tree.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 *
 * n = number of nodes in the tree
 * h = height of the tree
 */
public class DiameterofBinaryTree {
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
     * Finds the diameter of the binary tree.
     */
    public int diameterOfBinaryTree(TreeNode root) {

        // Stores the maximum diameter found so far.
        int[] diameter = new int[1];

        maxHeight(root, diameter);

        return diameter[0];
    }

    /**
     * Calculates the height of the tree and updates
     * the maximum diameter.
     */
    private int maxHeight(TreeNode root, int[] diameter) {

        // Height of an empty tree is 0.
        if (root == null) {
            return 0;
        }

        // Calculate height of left subtree.
        int leftHeight = maxHeight(root.left, diameter);

        // Calculate height of right subtree.
        int rightHeight = maxHeight(root.right, diameter);

        /*
         * Diameter passing through the current node:
         *
         * left height + right height
         */
        diameter[0] = Math.max(
                diameter[0],
                leftHeight + rightHeight
        );

        // Return height of the current subtree.
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {

        /*
                 1
                / \
               2   3
              / \
             4   5

             Longest path:
             4 -> 2 -> 1 -> 3

             Diameter = 3 edges
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        DiameterofBinaryTree solution = new DiameterofBinaryTree();

        System.out.println(
                "Diameter of Binary Tree: "
                + solution.diameterOfBinaryTree(root)
        );
    } 
}
