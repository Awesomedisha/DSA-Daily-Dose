class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        

            

        // Graph:
        // variable -> (neighbor, weight)
        Map<String, List<Edge>> graph = new HashMap<>();

        // Build graph
        for (int i = 0; i < equations.size(); i++) {

            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            double value = values[i];

            // a / b = value
            graph.computeIfAbsent(a, x -> new ArrayList<>())
                 .add(new Edge(b, value));

            // b / a = 1 / value
            graph.computeIfAbsent(b, x -> new ArrayList<>())
                 .add(new Edge(a, 1.0 / value));
        }

        double[] answer = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {

            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            // Unknown variable
            if (!graph.containsKey(start) ||
                !graph.containsKey(end)) {

                answer[i] = -1.0;
                continue;
            }

            // Same variable
            if (start.equals(end)) {
                answer[i] = 1.0;
                continue;
            }

            Set<String> visited = new HashSet<>();

            answer[i] = dfs(
                    start,
                    end,
                    1.0,
                    graph,
                    visited
            );
        }

        return answer;
    }

    private double dfs(
            String current,
            String target,
            double product,
            Map<String, List<Edge>> graph,
            Set<String> visited) {

        // Found target
        if (current.equals(target)) {
            return product;
        }

        visited.add(current);

        for (Edge edge : graph.get(current)) {

            if (visited.contains(edge.node)) {
                continue;
            }

            double result = dfs(
                    edge.node,
                    target,
                    product * edge.weight,
                    graph,
                    visited
            );

            // Path found
            if (result != -1.0) {
                return result;
            }
        }

        // No path exists
        return -1.0;
    }

    static class Edge {
        String node;
        double weight;

        Edge(String node, double weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}
        
    