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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        

        // If subRoot is empty, it is a subtree
        if (subRoot == null) {
            return true;
        }

        // If root is empty but subRoot is not,
        // subRoot cannot be found
        if (root == null) {
            return false;
        }

        // Check if the trees starting from these nodes are the same
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // Search for subRoot in the left subtree
        if (isSubtree(root.left, subRoot)) {
            return true;
        }

        // Search for subRoot in the right subtree
        if (isSubtree(root.right, subRoot)) {
            return true;
        }

        // subRoot was not found
        return false;
    }


    private boolean isSameTree(TreeNode p, TreeNode q) {

        // Both nodes are empty
        if (p == null && q == null) {
            return true;
        }

        // Only one node is empty
        if (p == null || q == null) {
            return false;
        }

        // Values are different
        if (p.val != q.val) {
            return false;
        }

        // Left sides must be same
        boolean leftSame = isSameTree(p.left, q.left);

        // Right sides must be same
        boolean rightSame = isSameTree(p.right, q.right);

        // Both sides must be same
        return leftSame && rightSame;
    }
}
        
    