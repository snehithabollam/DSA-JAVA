import java.util.HashMap;
public class ConstructBinaryTreefromInorderandPostorder {

/**
 * Problem: Construct Binary Tree from Inorder and Postorder Traversal
 *
 * Given two integer arrays:
 * 1. inorder   - Inorder traversal of a binary tree
 * 2. postorder - Postorder traversal of the same binary tree
 *
 * Construct and return the binary tree.
 *
 * Approach:
 * - The last element of postorder is always the root.
 * - Find the root's position in inorder using a HashMap.
 * - Elements before the root in inorder belong to the left subtree.
 * - Elements after the root in inorder belong to the right subtree.
 * - Recursively construct the left and right subtrees.
 *
 * Time Complexity: O(n)
 * - Building the HashMap takes O(n).
 * - Each node is processed once during tree construction.
 *
 * Space Complexity: O(n)
 * - HashMap stores the index of every node: O(n).
 * - Recursion stack can take O(n) in the worst case.
 *
 * where n = number of nodes in the binary tree.
 */

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        // Edge case
        if (inorder == null || postorder == null ||
            inorder.length != postorder.length ||
            inorder.length == 0) {
            return null;
        }

        // Store inorder element -> index
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }

        // Construct the tree
        return buildTreePostIn(
            inorder,
            0,
            inorder.length - 1,
            postorder,
            0,
            postorder.length - 1,
            hm
        );
    }

    private TreeNode buildTreePostIn(
            int[] inorder,
            int is,
            int ie,
            int[] postorder,
            int ps,
            int pe,
            HashMap<Integer, Integer> hm) {

        // Base case
        if (ps > pe || is > ie) {
            return null;
        }

        // Last element of postorder is the root
        TreeNode root = new TreeNode(postorder[pe]);

        // Find root position in inorder
        int inRoot = hm.get(postorder[pe]);

        // Number of nodes in the left subtree
        int numsLeft = inRoot - is;

        // Build left subtree
        root.left = buildTreePostIn(
            inorder,
            is,
            inRoot - 1,
            postorder,
            ps,
            ps + numsLeft - 1,
            hm
        );

        // Build right subtree
        root.right = buildTreePostIn(
            inorder,
            inRoot + 1,
            ie,
            postorder,
            ps + numsLeft,
            pe - 1,
            hm
        );

        return root;
    }
}

