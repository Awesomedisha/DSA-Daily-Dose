

class Solution {
    int[] parent, size;

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        parent = new int[n * n];
        size = new int[n * n];

        for (int i = 0; i < n * n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // Step 1: union all 1-cells
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) continue;

                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k], nc = c + dc[k];
                    if (nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 1) {
                        union(r * n + c, nr * n + nc);
                    }
                }
            }
        }

        int ans = 0;

        // Step 2: try flipping each zero
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) continue;

                Set<Integer> set = new HashSet<>();
                int cur = 1;

                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k], nc = c + dc[k];
                    if (nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 1) {
                        int root = find(nr * n + nc);
                        if (set.add(root)) {
                            cur += size[root];
                        }
                    }
                }

                ans = Math.max(ans, cur);
            }
        }

        // case when grid already full of 1s
        for (int i = 0; i < n * n; i++) {
            if (parent[i] == i) ans = Math.max(ans, size[i]);
        }

        return ans;
    }

    private int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) return;

        parent[pb] = pa;
        size[pa] += size[pb];
    }
}