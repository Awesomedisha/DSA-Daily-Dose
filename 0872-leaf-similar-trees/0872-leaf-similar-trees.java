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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        collectLeaves(root1, leaves1);
        collectLeaves(root2, leaves2);

        return leaves1.equals(leaves2);
    }

    private void collectLeaves(TreeNode root, List<Integer> leaves) {

        // If node is null, stop
        if (root == null) {
            return;
        }

        // If this is a leaf, store its value
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return;
        }

        // Visit left subtree
        collectLeaves(root.left, leaves);

        // Visit right subtree
        collectLeaves(root.right, leaves);
    }
}