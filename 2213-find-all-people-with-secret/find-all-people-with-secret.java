

class DSU {

    int[] parent;
    int[] rank;

    // Constructor
    DSU(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];

        // Initially every node is its own parent
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Find parent with path compression
    int findParent(int node) {
        if (node == parent[node]) {
            return node;
        }

        parent[node] = findParent(parent[node]);
        return parent[node];
    }

    // Reset a node (disconnect it from group)
    void resetNode(int node) {
        parent[node] = node;
        rank[node] = 0;
    }

    // Union by rank
    void unionNodes(int node1, int node2) {

        int parent1 = findParent(node1);
        int parent2 = findParent(node2);

        if (parent1 == parent2) {
            return;
        }

        if (rank[parent1] > rank[parent2]) {
            parent[parent2] = parent1;
        }
        else if (rank[parent1] < rank[parent2]) {
            parent[parent1] = parent2;
        }
        else {
            parent[parent1] = parent2;
            rank[parent2]++;
        }
    }
}

class Solution {

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        List<Integer> ans = new ArrayList<>();

        // Sort meetings based on time
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

        DSU dsu = new DSU(n);

        // Person 0 shares secret with firstPerson
        dsu.unionNodes(0, firstPerson);

        int i = 0;

        while (i < meetings.length) {

            int time = meetings[i][2];
            List<Integer> people = new ArrayList<>();

            // Process meetings with same time
            while (i < meetings.length && meetings[i][2] == time) {

                int a = meetings[i][0];
                int b = meetings[i][1];

                dsu.unionNodes(a, b);

                people.add(a);
                people.add(b);

                i++;
            }

            // Check who actually knows the secret
            for (int person : people) {

                if (dsu.findParent(person) != dsu.findParent(0)) {
                    dsu.resetNode(person);
                }
            }
        }

        // Collect all people connected with 0
        for (int person = 0; person < n; person++) {

            if (dsu.findParent(person) == dsu.findParent(0)) {
                ans.add(person);
            }
        }

        return ans;
    }
}