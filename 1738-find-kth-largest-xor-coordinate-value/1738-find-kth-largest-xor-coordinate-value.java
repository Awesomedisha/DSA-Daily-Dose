class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
       

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] prefix = new int[m][n];

      
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                prefix[i][j] = matrix[i][j];

               
                if (i > 0) {
                    prefix[i][j] ^= prefix[i - 1][j];
                }

               
                if (j > 0) {
                    prefix[i][j] ^= prefix[i][j - 1];
                }

                
                if (i > 0 && j > 0) {
                    prefix[i][j] ^= prefix[i - 1][j - 1];
                }
            }
        }

      
        int[] values = new int[m * n];
        int index = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                values[index++] = prefix[i][j];
            }
        }

        
        Arrays.sort(values);

      
        return values[values.length - k];
    }
}
        
