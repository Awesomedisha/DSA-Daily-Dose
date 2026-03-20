class Solution {
    public int getImportance(List<Employee> employees, int id) {
        
        // Step 1: Map create karna (id -> Employee)
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        
        // Step 2: DFS call
        return dfs(id, map);
    }
    
    // DFS function
    private int dfs(int id, Map<Integer, Employee> map) {
        Employee emp = map.get(id);
        
        int total = emp.importance; // khud ki importance
        
        // Step 3: sab subordinates ka importance add karo
        for (int subId : emp.subordinates) {
            total += dfs(subId, map);
        }
        
        return total;
    }
}