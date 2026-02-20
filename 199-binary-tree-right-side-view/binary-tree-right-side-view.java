
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
    




    
        List<Integer> result = new ArrayList<>();

        // edge case
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size(); // current level ka size

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // level ka last node hi right view mein dikhega
                if (i == size - 1) {
                    result.add(node.val);
                }

                // normal BFS expansion
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return result;
    }
}

    