

class Graph {

    private List<List<int[]>> adj;
    private int n;

    public Graph(int n, int[][] edges) {
        this.n = n;
        adj = new ArrayList<>();

        // create adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // add initial edges
        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
        }
    }

    public void addEdge(int[] edge) {
        // add new directed edge
        adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
    }

    public int shortestPath(int node1, int node2) {

        // distance array
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // min heap -> {cost, node}
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        dist[node1] = 0;
        pq.offer(new int[]{0, node1});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int node = curr[1];

            // early exit (important)
            if (node == node2) return cost;

            // skip outdated entries
            if (cost > dist[node]) continue;

            // relax neighbors
            for (int[] nei : adj.get(node)) {
                int next = nei[0];
                int w = nei[1];

                if (cost + w < dist[next]) {
                    dist[next] = cost + w;
                    pq.offer(new int[]{dist[next], next});
                }
            }
        }

        return -1; // unreachable
    }
}
