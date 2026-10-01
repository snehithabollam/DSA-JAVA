//Definition for Node
class Node{
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class FloorinBST {

    /**
     * Finds the floor of k in a Binary Search Tree.
     *
     * The floor is the largest value in the BST
     * that is less than or equal to k.
     *
     * Approach:
     * - If root.data == k, k itself is the floor.
     * - If k is smaller than root.data, move to the left subtree.
     * - If k is greater than root.data, the current node is a
     *   possible floor, so store it and move to the right subtree
     *   to find a larger valid value.
     *
     * Time Complexity: O(h)
     * - Average: O(log n) for a balanced BST
     * - Worst: O(n) for a skewed BST
     *
     * Space Complexity: O(1)
     * - Uses iterative traversal.
     */
    public int findMaxFork(Node root, int k) {

        int floor = -1;

        while (root != null) {

            // If k is found, k itself is the floor
            if (root.data == k) {
                return root.data;
            }

            // If k is smaller, search in the left subtree
            if (k < root.data) {
                root = root.left;
            } 
            else {
                // Current node is a possible floor
                floor = root.data;

                // Search for a larger value that is still <= k
                root = root.right;
            }
        }

        // Return -1 if no floor exists
        return floor;
    }
}
