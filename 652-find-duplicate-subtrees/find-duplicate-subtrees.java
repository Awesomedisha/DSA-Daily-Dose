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
    //public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    
    HashMap<String, Integer> map = new HashMap<>();
    List<TreeNode> result = new ArrayList<>();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return result;
    }
    
    public String serialize(TreeNode node) {
        // base case
        if (node == null) return "null";
        
        // postorder traversal
        String left = serialize(node.left);
        String right = serialize(node.right);
        
        // subtree representation
        String curr = node.val + "," + left + "," + right;
        
        // count increase karo
        map.put(curr, map.getOrDefault(curr, 0) + 1);
        
        // agar 2nd time mila -> duplicate
        if (map.get(curr) == 2) {
            result.add(node);
        }
        
        return curr;
    }
}
        
    