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
    public int amountOfTime(TreeNode root, int start) {
        
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        TreeNode startNode = markParent(root, null, start, parent);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(startNode);
        visited.add(startNode);

        int minutes = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            minutes++;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    queue.offer(curr.left);
                }

                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    queue.offer(curr.right);
                }

                TreeNode par = parent.get(curr);
                if (par != null && !visited.contains(par)) {
                    visited.add(par);
                    queue.offer(par);
                }
            }
        }

        return minutes;
    }

    private TreeNode markParent(TreeNode node, TreeNode par,
                                int start,
                                Map<TreeNode, TreeNode> parent) {

        if (node == null) return null;

        parent.put(node, par);

        TreeNode result = null;

        if (node.val == start) {
            result = node;
        }

        TreeNode left = markParent(node.left, node, start, parent);
        TreeNode right = markParent(node.right, node, start, parent);

        if (left != null) result = left;
        if (right != null) result = right;

        return result;
    }
}


        
    