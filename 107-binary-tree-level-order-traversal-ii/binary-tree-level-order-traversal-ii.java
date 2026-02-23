

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        // edge case
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            // ek level process karo
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);

                // left child
                if (node.left != null) q.offer(node.left);

                // right child
                if (node.right != null) q.offer(node.right);
            }

            // 🔥 bottom-up trick (front me add)
            result.add(0, level);
        }

        return result;
    }
}