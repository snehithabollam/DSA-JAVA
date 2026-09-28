import java.util.HashMap;
public class ConstructBinaryTreefromInorderandPerorder {


/**
 * Problem: Construct Binary Tree from Preorder and Inorder Traversal
 *
 * Given two integer arrays:
 * 1. preorder - Preorder traversal of a binary tree
 * 2. inorder  - Inorder traversal of the same binary tree
 *
 * Construct and return the binary tree.
 *
 * Approach:
 * - The first element of preorder is always the root.
 * - Find the root's position in inorder using a HashMap.
 * - Elements before the root in inorder belong to the left subtree.
 * - Elements after the root in inorder belong to the right subtree.
 * - Recursively construct the left and right subtrees.
 *
 * Time Complexity: O(n)
 * - Building the HashMap takes O(n).
 * - Each node is processed exactly once.
 *
 * Space Complexity: O(n)
 * - HashMap stores the index of every node: O(n).
 * - Recursion stack can take O(n) in the worst case.
 *
 * where n = number of nodes in the binary tree.
 */

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Edge cases
        if (inorder == null || preorder == null ||
            inorder.length != preorder.length ||
            inorder.length == 0) {
            return null;
        }

        // Store inorder element -> index
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }

        // Construct the tree
        return buildTreePreIn(
            inorder,
            0,
            inorder.length - 1,
            preorder,
            0,
            preorder.length - 1,
            hm
        );
    }

    private TreeNode buildTreePreIn(
            int[] inorder,
            int is,
            int ie,
            int[] preorder,
            int ps,
            int pe,
            HashMap<Integer, Integer> hm) {

        // Base case
        if (ps > pe || is > ie) {
            return null;
        }

        // First element of preorder is the root
        TreeNode root = new TreeNode(preorder[ps]);

        // Find root position in inorder
        int inRoot = hm.get(preorder[ps]);

        // Number of nodes in the left subtree
        int numsLeft = inRoot - is;

        // Build left subtree
        root.left = buildTreePreIn(
            inorder,
            is,
            inRoot - 1,
            preorder,
            ps + 1,
            ps + numsLeft,
            hm
        );

        // Build right subtree
        root.right = buildTreePreIn(
            inorder,
            inRoot + 1,
            ie,
            preorder,
            ps + numsLeft + 1,
            pe,
            hm
        );

        return root;
    }
}
