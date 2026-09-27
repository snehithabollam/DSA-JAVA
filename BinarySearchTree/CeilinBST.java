class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

class CeilinBST {

    /**
     * Finds the ceil of x in a Binary Search Tree.
     *
     * The ceil is the smallest value in the BST
     * that is greater than or equal to x.
     *
     * Time Complexity: O(h)
     * - Average: O(log n) for a balanced BST
     * - Worst: O(n) for a skewed BST
     *
     * Space Complexity: O(1)
     * - Iterative approach uses constant extra space.
     */
    int findCeil(Node root, int x) {

        int ceil = -1;

        while (root != null) {

            // If x is found, x itself is the ceil
            if (root.data == x) {
                return root.data;
            }

            // If x is greater, search in the right subtree
            if (x > root.data) {
                root = root.right;
            } 
            else {
                // Current node is a possible ceil
                ceil = root.data;

                // Search left for a smaller valid ceil
                root = root.left;
            }
        }

        // Return -1 if no ceil exists
        return ceil;
    }
}
