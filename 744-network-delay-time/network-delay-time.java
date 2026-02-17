class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        



        // Step 1: adjacency list banao
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // graph fill karo
        for (int[] t : times) {
            int u = t[0];
            int v = t[1];
            int w = t[2];
            graph.get(u).add(new int[]{v, w});
        }

        // Step 2: distance array (initially infinity)
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Step 3: min heap → (time, node)
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // source initialize
        dist[k] = 0;
        pq.offer(new int[]{0, k});

        // Step 4: Dijkstra
        while (!pq.isEmpty()) {

            int[] curr = pq.poll();
            int time = curr[0];
            int node = curr[1];

            // outdated entry skip karo
            if (time > dist[node]) continue;

            // neighbors explore karo
            for (int[] nei : graph.get(node)) {
                int next = nei[0];
                int wt = nei[1];

                if (dist[next] > time + wt) {
                    dist[next] = time + wt;
                    pq.offer(new int[]{dist[next], next});
                }
            }
        }

        // Step 5: answer = max distance
        int maxTime = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; // koi node unreachable hai
            }
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}

        
    
