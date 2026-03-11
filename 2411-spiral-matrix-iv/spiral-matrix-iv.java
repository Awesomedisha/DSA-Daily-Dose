

class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {

        int[][] matrix = new int[m][n];

        // fill with -1
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = -1;
            }
        }

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while(head != null && top <= bottom && left <= right){

            // left → right
            for(int i = left; i <= right && head != null; i++){
                matrix[top][i] = head.val;
                head = head.next;
            }
            top++;

            // top → bottom
            for(int i = top; i <= bottom && head != null; i++){
                matrix[i][right] = head.val;
                head = head.next;
            }
            right--;

            // right → left
            for(int i = right; i >= left && head != null; i--){
                matrix[bottom][i] = head.val;
                head = head.next;
            }
            bottom--;

            // bottom → top
            for(int i = bottom; i >= top && head != null; i--){
                matrix[i][left] = head.val;
                head = head.next;
            }
            left++;
        }

        return matrix;
    }
}
        
    