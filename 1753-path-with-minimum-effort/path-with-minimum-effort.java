class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        


        int rows = heights.length;
        int cols = heights[0].length;

        int left = 0, right = 1_000_000;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canReach(heights, mid, rows, cols)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean canReach(int[][] heights, int limit, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            if (r == rows - 1 && c == cols - 1) return true;

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && !visited[nr][nc]) {
                    int diff = Math.abs(heights[r][c] - heights[nr][nc]);
                    if (diff <= limit) {
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        return false;
    }
}
    
