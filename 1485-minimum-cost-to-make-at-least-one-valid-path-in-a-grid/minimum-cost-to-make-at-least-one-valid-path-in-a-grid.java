class Solution {
    public int minCost(int[][] grid) {
        

        int m = grid.length;
        int n = grid[0].length;

        int[][] dirs = {
                {0,1},   // right
                {0,-1},  // left
                {1,0},   // down
                {-1,0}   // up
        };

        int[][] dist = new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Deque<int[]> dq = new ArrayDeque<>();

        dq.offerFirst(new int[]{0,0});
        dist[0][0] = 0;

        while(!dq.isEmpty()){

            int[] cur = dq.pollFirst();
            int r = cur[0];
            int c = cur[1];

            for(int d=0; d<4; d++){

                int nr = r + dirs[d][0];
                int nc = c + dirs[d][1];

                if(nr<0 || nc<0 || nr>=m || nc>=n) continue;

                // agar direction same hai grid sign ke
                int cost = (grid[r][c] == d+1) ? 0 : 1;

                if(dist[r][c] + cost < dist[nr][nc]){

                    dist[nr][nc] = dist[r][c] + cost;

                    if(cost == 0)
                        dq.offerFirst(new int[]{nr,nc});
                    else
                        dq.offerLast(new int[]{nr,nc});
                }
            }
        }

        return dist[m-1][n-1];
    }
}
        
    