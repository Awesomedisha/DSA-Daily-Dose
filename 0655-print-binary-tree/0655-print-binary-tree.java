/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<String>> printTree(TreeNode root) {
        

        // Find the height of the tree
        int height = getHeight(root);

        // Number of rows
        int rows = height + 1;

        // Number of columns
        // 2^(height + 1) - 1
        int cols = (1 << (height + 1)) - 1;

        // Create the answer matrix
        List<List<String>> res = new ArrayList<>();

        // Fill every cell with an empty string
        for (int i = 0; i < rows; i++) {

            List<String> row = new ArrayList<>();

            for (int j = 0; j < cols; j++) {
                row.add("");
            }

            res.add(row);
        }

        // Root goes in the middle
        int middle = (cols - 1) / 2;

        // Place all nodes
        fill(res, root, 0, middle, height);

        return res;
    }


    private void fill(
            List<List<String>> res,
            TreeNode root,
            int row,
            int col,
            int height) {

        // If there is no node, stop
        if (root == null) {
            return;
        }

        // Put the current node in the matrix
        res.get(row).set(col, String.valueOf(root.val));

        // Calculate how far the children should be
        int offset = 1 << (height - row - 1);

        // Place the left child
        if (root.left != null) {

            fill(
                res,
                root.left,
                row + 1,
                col - offset,
                height
            );
        }

        // Place the right child
        if (root.right != null) {

            fill(
                res,
                root.right,
                row + 1,
                col + offset,
                height
            );
        }
    }


    private int getHeight(TreeNode root) {

        // Empty tree has height -1
        if (root == null) {
            return -1;
        }

        // Find height of left subtree
        int leftHeight = getHeight(root.left);

        // Find height of right subtree
        int rightHeight = getHeight(root.right);

        // Current height is 1 + bigger subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
        
    