
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        


        HashMap<Long, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0L, 1); // base case
        
        return dfs(root, 0L, targetSum, prefixMap);
    }
    
    private int dfs(TreeNode node, long currSum, int target, HashMap<Long, Integer> map) {
        if (node == null) return 0;
        
        currSum += node.val;
        
        int count = map.getOrDefault(currSum - target, 0);
        
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        
        count += dfs(node.left, currSum, target, map);
        count += dfs(node.right, currSum, target, map);
        
        // backtrack
        map.put(currSum, map.get(currSum) - 1);
        
        return count;
    }
}

        
    