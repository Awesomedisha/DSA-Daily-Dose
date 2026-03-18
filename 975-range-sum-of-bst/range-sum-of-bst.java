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
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        return dfs(root, low, high);
    }

    public int dfs(TreeNode node, int low, int high) {
        if (node == null) return 0;

        // case 1: value chhoti hai → left useless
        if (node.val < low) {
            return dfs(node.right, low, high);
        }

        // case 2: value badi hai → right useless
        if (node.val > high) {
            return dfs(node.left, low, high);
        }

        // case 3: range me hai
        return node.val 
             + dfs(node.left, low, high)
             + dfs(node.right, low, high);
    }
}
        
    