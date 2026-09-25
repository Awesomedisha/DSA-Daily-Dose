class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        

        int n = values.length;

        // Store {value, label}
        int[][] items = new int[n][2];

        for (int i = 0; i < n; i++) {
            items[i][0] = values[i];
            items[i][1] = labels[i];
        }

        // Sort by value in descending order
        Arrays.sort(items, (a, b) -> b[0] - a[0]);

        HashMap<Integer, Integer> used = new HashMap<>();

        int sum = 0;
        int count = 0;

        for (int[] item : items) {

            int value = item[0];
            int label = item[1];

            // Stop after selecting numWanted items
            if (count == numWanted) {
                break;
            }

            // How many times this label has been used
            int labelCount = used.getOrDefault(label, 0);

            // Can't exceed useLimit
            if (labelCount < useLimit) {

                sum += value;
                count++;

                used.put(label, labelCount + 1);
            }
        }

        return sum;
    }
}
        
    