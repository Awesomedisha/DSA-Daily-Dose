class Solution {
    public int longestCycle(int[] edges) {
        
    
        int n = edges.length;
        boolean[] visited = new boolean[n];
        int longest = -1;

        for (int i = 0; i < n; i++) {

            if (visited[i]) continue;

            int current = i;
            int step = 0;

            // Map to store node -> step index in current traversal
            java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();

            while (current != -1 && !visited[current]) {

                visited[current] = true;
                map.put(current, step++);
                current = edges[current];

                // Cycle detected inside current traversal
                if (current != -1 && map.containsKey(current)) {
                    int cycleLength = step - map.get(current);
                    longest = Math.max(longest, cycleLength);
                    break;
                }
            }
        }

        return longest;
    }
}

        
    