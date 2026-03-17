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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
       
        // agar root1 null hai -> root2 return karo
        if (root1 == null) return root2;
        
        // agar root2 null hai -> root1 return karo
        if (root2 == null) return root1;
        
        // dono exist karte hain -> values add karo
        TreeNode merged = new TreeNode(root1.val + root2.val);
        
        // left subtree merge karo
        merged.left = mergeTrees(root1.left, root2.left);
        
        // right subtree merge karo
        merged.right = mergeTrees(root1.right, root2.right);
        
        return merged;
    }
}
        
    