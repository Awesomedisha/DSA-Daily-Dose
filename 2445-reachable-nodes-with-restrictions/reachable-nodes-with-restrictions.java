class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        
        
        // Step 1: Graph build karo
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Step 2: restricted ko set me daalo (fast lookup)
        Set<Integer> restrictedSet = new HashSet<>();
        for (int r : restricted) {
            restrictedSet.add(r);
        }

        // Step 3: DFS
        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited, restrictedSet);
    }

    public int dfs(int node, List<List<Integer>> graph, boolean[] visited, Set<Integer> restrictedSet) {
        
        // agar restricted ya visited hai → skip
        if (visited[node] || restrictedSet.contains(node)) {
            return 0;
        }

        visited[node] = true;

        int count = 1; // current node count karo

        for (int nei : graph.get(node)) {
            count += dfs(nei, graph, visited, restrictedSet);
        }

        return count;
    }
}
    