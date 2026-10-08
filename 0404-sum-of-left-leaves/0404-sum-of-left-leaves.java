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
    public int sumOfLeftLeaves(TreeNode root) {
        
        // If the tree is empty, there are no leaves.
        // Therefore, the sum is 0.

        if (root == null) {
            return 0;
        }


        // We will store the sum of all left leaves
        // found in the tree.

        int sum = 0;


        // First, check whether the current node
        // has a left child.

        if (root.left != null) {

            // Now check whether the LEFT CHILD is a leaf.
            //
            // A leaf has:
            //      no left child
            //      AND
            //      no right child

            if (root.left.left == null &&
                root.left.right == null) {

                // root.left is a left leaf.
                //
                // Add its value to our sum.

                sum += root.left.val;
            }
        }


        // Now recursively search the LEFT subtree.
        //
        // There may be more left leaves deeper
        // inside this subtree.

        sum += sumOfLeftLeaves(root.left);


        // Now recursively search the RIGHT subtree.
        //
        // There may also be left leaves inside
        // the right subtree.

        sum += sumOfLeftLeaves(root.right);


        // Return the total sum found so far.

        return sum;
    }
}
        
    