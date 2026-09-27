class Solution {

    // Stores:
    // Original Node → Cloned Node
    HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {

        // If graph is empty
        if (node == null) {
            return null;
        }

        // If we have already cloned this node,
        // return the existing clone.
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // Create a new node with the same value
        Node clone = new Node(node.val);

        // Store it immediately
        // This prevents infinite loops in cycles.
        map.put(node, clone);

        // Visit all neighbors of the original node
        for (Node neighbor : node.neighbors) {

            // Clone the neighbor and add it
            // to the cloned node's neighbors.
            clone.neighbors.add(cloneGraph(neighbor));
        }

        // Return the cloned node
        return clone;
    }
}