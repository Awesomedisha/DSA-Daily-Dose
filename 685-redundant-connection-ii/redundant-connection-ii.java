//class Solution {
    //public int[] findRedundantDirectedConnection(int[][] edges) {
        

    class DSU {
        int parent[];

        DSU(int n){
            parent = new int[n+1];
            for(int i=1;i<=n;i++)
                parent[i]=i;
        }

        int find(int x){
            if(parent[x]!=x)
                parent[x]=find(parent[x]); // path compression
            return parent[x];
        }

        boolean union(int a,int b){

            int pa=find(a);
            int pb=find(b);

            if(pa==pb) return false; // cycle

            parent[pb]=pa;
            return true;
        }
    }
class Solution {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        


    
        int n = edges.length;

        int[] parent = new int[n+1];

        int[] cand1 = null;
        int[] cand2 = null;

        // Step 1: detect node with two parents
        for(int[] e: edges){

            int u = e[0];
            int v = e[1];

            if(parent[v]==0){
                parent[v]=u;
            }
            else{

                cand1 = new int[]{parent[v], v};
                cand2 = new int[]{u, v};

                e[1] = 0; // invalidate edge
            }
        }

        DSU dsu = new DSU(n);

        // Step 2: detect cycle
        for(int[] e: edges){

            int u=e[0];
            int v=e[1];

            if(v==0) continue;

            if(!dsu.union(u,v)){

                if(cand1==null)
                    return e;

                return cand1;
            }
        }

        return cand2;
    }
}
        
    