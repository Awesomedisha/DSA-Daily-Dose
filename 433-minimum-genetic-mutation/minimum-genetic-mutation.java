class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        


        HashSet<String> set = new HashSet<>();

        // bank ko set me daalo (fast search)
        for (String gene : bank) {
            set.add(gene);
        }

        // agar endGene bank me hi nahi hai → impossible
        if (!set.contains(endGene)) {
            return -1;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(startGene);

        HashSet<String> visited = new HashSet<>();
        visited.add(startGene);

        int steps = 0;

        char[] chars = {'A', 'C', 'G', 'T'};

        // BFS start
        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                String curr = q.poll();

                // target mil gaya
                if (curr.equals(endGene)) {
                    return steps;
                }

                char[] arr = curr.toCharArray();

                // har position change karo
                for (int j = 0; j < 8; j++) {

                    char original = arr[j];

                    // A,C,G,T try karo
                    for (char ch : chars) {

                        arr[j] = ch;
                        String next = new String(arr);

                        // valid mutation check
                        if (set.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            q.offer(next);
                        }
                    }

                    // character wapas restore karo
                    arr[j] = original;
                }
            }

            steps++; // ek level complete → ek mutation
        }

        return -1;
    }
}

        
    