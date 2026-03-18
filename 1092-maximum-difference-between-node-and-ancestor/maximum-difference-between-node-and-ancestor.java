class Solution {
    int ans = 0;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return ans;
    }

    public void dfs(TreeNode node, int min, int max) {
        if (node == null) return;

        // current node ke saath difference calculate karo
        int currDiff = Math.max(Math.abs(node.val - min), 
                                Math.abs(node.val - max));

        ans = Math.max(ans, currDiff);

        // min aur max update karo
        min = Math.min(min, node.val);
        max = Math.max(max, node.val);

        // left aur right me jao
        dfs(node.left, min, max);
        dfs(node.right, min, max);
    }
}