

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // 🔹 Step 1: adjacency list banana
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>()); // har course ke liye empty list
        }

        // 🔹 indegree array
        int[] indegree = new int[numCourses];

        // 🔹 Step 2: graph build karna
        for (int[] pre : prerequisites) {

            int course = pre[0];   // jo lena hai
            int prereq = pre[1];   // jo pehle lena hai

            adj.get(prereq).add(course); // edge prereq → course
            indegree[course]++;          // indegree badhao
        }

        // 🔹 Step 3: queue me sab indegree 0 wale daalo
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // 🔹 result list
        int[] result = new int[numCourses];
        int index = 0;

        // 🔹 Step 4: BFS (Kahn's algorithm)
        while (!q.isEmpty()) {

            int node = q.poll();
            result[index++] = node; // order me add

            // neighbors ke indegree kam karo
            for (int neigh : adj.get(node)) {
                indegree[neigh]--;

                if (indegree[neigh] == 0) {
                    q.offer(neigh);
                }
            }
        }

        // 🔹 Step 5: cycle check
        if (index != numCourses) {
            return new int[0]; // cycle → impossible
        }

        return result;
    }
}
