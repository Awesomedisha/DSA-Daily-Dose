class Solution {

    public int countNodes(TreeNode root) {

        // If tree is empty, there are 0 nodes
        if (root == null) {
            return 0;
        }

        // Find height of the leftmost path
        int leftHeight = getLeftHeight(root);

        // Find height of the rightmost path
        int rightHeight = getRightHeight(root);

        // If both heights are same,
        // this subtree is a perfect binary tree
        if (leftHeight == rightHeight) {

            // Number of nodes in a perfect tree
            return (1 << leftHeight) - 1;
        }

        // If it is not perfect,
        // count the root + left subtree + right subtree
        return 1
                + countNodes(root.left)
                + countNodes(root.right);
    }

    // Find how many nodes are present on the leftmost path
    private int getLeftHeight(TreeNode root) {

        int height = 0;

        while (root != null) {

            height++;

            root = root.left;
        }

        return height;
    }

    // Find how many nodes are present on the rightmost path
    private int getRightHeight(TreeNode root) {

        int height = 0;

        while (root != null) {

            height++;

            root = root.right;
        }

        return height;
    }
}