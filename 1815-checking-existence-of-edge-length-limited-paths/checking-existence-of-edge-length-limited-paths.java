

class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] q) {

        boolean[] ans = new boolean[q.length];

        int[][] queries = new int[q.length][4];

        for (int i = 0; i < q.length; i++) {
            queries[i][0] = q[i][0];
            queries[i][1] = q[i][1];
            queries[i][2] = q[i][2];
            queries[i][3] = i;
        }

        Arrays.sort(queries, (a, b) -> a[2] - b[2]);

        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);

        DSU dsu = new DSU(n);

        int i = 0;

        for (int j = 0; j < queries.length; j++) {

            int u = queries[j][0];
            int v = queries[j][1];
            int limit = queries[j][2];
            int idx = queries[j][3];

            while (i < edgeList.length && edgeList[i][2] < limit) {

                dsu.union(edgeList[i][0], edgeList[i][1]);
                i++;
            }

            if (dsu.find(u) == dsu.find(v)) {
                ans[idx] = true;
            }
        }

        return ans;
    }
}

class DSU {

    int[] parent;
    int[] rank;

    DSU(int n) {

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int x) {

        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    void union(int a, int b) {

        int pa = find(a);
        int pb = find(b);

        if (pa == pb) return;

        if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
        } 
        else if (rank[pb] < rank[pa]) {
            parent[pb] = pa;
        } 
        else {
            parent[pb] = pa;
            rank[pa]++;
        }
    }
}