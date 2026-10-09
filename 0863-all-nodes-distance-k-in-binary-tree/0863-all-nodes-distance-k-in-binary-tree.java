import java.util.*;

class Solution {

    Map<TreeNode, TreeNode> parent = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        markParents(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int distance = 0;

        while (!queue.isEmpty()) {

            if (distance == k) {
                List<Integer> result = new ArrayList<>();

                for (TreeNode node : queue) {
                    result.add(node.val);
                }

                return result;
            }

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                if (node.left != null && visited.add(node.left)) {
                    queue.offer(node.left);
                }

                if (node.right != null && visited.add(node.right)) {
                    queue.offer(node.right);
                }

                TreeNode p = parent.get(node);

                if (p != null && visited.add(p)) {
                    queue.offer(p);
                }
            }

            distance++;
        }

        return new ArrayList<>();
    }

    private void markParents(TreeNode node, TreeNode p) {

        if (node == null) {
            return;
        }

        parent.put(node, p);

        markParents(node.left, node);
        markParents(node.right, node);
    }
}