class Solution {
    public int shortestPathLength(int[][] graph) {
        

        int n = graph.length;

        // fullMask means ALL nodes are visited.
        // Example: n = 4
        // 1 << 4 = 10000
        // 10000 - 1 = 01111
        int fullMask = (1 << n) - 1;

        // Queue stores:
        // [current node, visited nodes mask, distance]
        Queue<int[]> queue = new LinkedList<>();

        // visited[node][mask] tells us whether
        // we have already reached this node
        // with this particular set of visited nodes.
        boolean[][] visited = new boolean[n][1 << n];

        // We can start from ANY node.
        // So put every node into the queue initially.
        for (int node = 0; node < n; node++) {

            // Mark the starting node as visited.
            int mask = 1 << node;

            // Distance is 0 because we have not moved yet.
            queue.offer(new int[]{node, mask, 0});

            // Mark this state as visited.
            visited[node][mask] = true;
        }

        // Normal BFS
        while (!queue.isEmpty()) {

            // Take the next state from the queue.
            int[] current = queue.poll();

            int node = current[0];
            int mask = current[1];
            int distance = current[2];

            // If all nodes have been visited,
            // return the current distance.
            //
            // BFS guarantees this is the shortest distance.
            if (mask == fullMask) {
                return distance;
            }

            // Visit all neighbors of the current node.
            for (int neighbor : graph[node]) {

                // Add the neighbor to our visited mask.
                int newMask = mask | (1 << neighbor);

                // If this state has not been visited before,
                // add it to the queue.
                if (!visited[neighbor][newMask]) {

                    visited[neighbor][newMask] = true;

                    // We moved one edge,
                    // so distance increases by 1.
                    queue.offer(
                        new int[]{neighbor, newMask, distance + 1}
                    );
                }
            }
        }

        // Graph is connected, so normally we never reach here.
        return -1;
    }
}
        
    