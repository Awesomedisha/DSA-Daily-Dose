class Solution {

    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    List<String> result = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        // Step 1: build graph
        for (List<String> ticket : tickets) {

            String from = ticket.get(0);
            String to = ticket.get(1);

            graph.putIfAbsent(from, new PriorityQueue<>());

            graph.get(from).offer(to); // lexicographically smallest milega
        }

        // Step 2: DFS
        dfs("JFK");

        // Step 3: reverse result
        Collections.reverse(result);

        return result;
    }

    void dfs(String airport) {

        PriorityQueue<String> pq = graph.get(airport);

        // jab tak outgoing flights exist karte hai
        while (pq != null && !pq.isEmpty()) {

            String next = pq.poll(); // smallest airport
            dfs(next);
        }

        // jab koi flight nahi bachi
        result.add(airport);
    }
}

