class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        

        int total = rows * cols;
        int[][] ans = new int[total][2];

        int index = 0;

        int r = rStart;
        int c = cStart;

        ans[index++] = new int[]{r, c};

        int step = 1;

        int[][] dir = {
            {0,1},   // east
            {1,0},   // south
            {0,-1},  // west
            {-1,0}   // north
        };

        while(index < total){

            for(int d = 0; d < 4; d++){

                for(int i = 0; i < step; i++){

                    r += dir[d][0];
                    c += dir[d][1];

                    if(r >= 0 && r < rows && c >= 0 && c < cols){
                        ans[index++] = new int[]{r,c};

                        if(index == total)
                            return ans;
                    }
                }

                // increase step after east & west moves
                if(d % 2 == 1)
                    step++;
            }
        }

        return ans;
    }
}
        
    