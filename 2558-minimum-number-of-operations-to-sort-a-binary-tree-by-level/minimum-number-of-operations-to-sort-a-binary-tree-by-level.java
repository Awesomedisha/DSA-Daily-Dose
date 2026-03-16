class Solution {

    public int minimumOperations(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int ans = 0;

        while(!q.isEmpty()){

            int size = q.size();
            int[] arr = new int[size];

            for(int i=0;i<size;i++){

                TreeNode node = q.poll();
                arr[i] = node.val;

                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }

            ans += minSwaps(arr);
        }

        return ans;
    }


    private int minSwaps(int[] arr){

        int n = arr.length;

        int[][] pair = new int[n][2];

        for(int i=0;i<n;i++){
            pair[i][0] = arr[i];
            pair[i][1] = i;
        }

        Arrays.sort(pair,(a,b)->a[0]-b[0]);

        boolean[] visited = new boolean[n];

        int swaps = 0;

        for(int i=0;i<n;i++){

            if(visited[i] || pair[i][1]==i) continue;

            int cycle = 0;
            int j = i;

            while(!visited[j]){

                visited[j] = true;
                j = pair[j][1];
                cycle++;
            }

            swaps += cycle-1;
        }

        return swaps;
    }
}