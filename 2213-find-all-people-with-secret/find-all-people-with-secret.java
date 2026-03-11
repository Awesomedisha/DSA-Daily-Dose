

class Solution {

    int[] parent;

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {







    
        parent = new int[n];


        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        
        union(0, firstPerson);

        
        Arrays.sort(meetings, (a,b) -> a[2] - b[2]);

        int i = 0;

        while(i < meetings.length){

            int time = meetings[i][2];

            List<Integer> list = new ArrayList<>();

            int j = i;

            
            while(j < meetings.length && meetings[j][2] == time){

                int x = meetings[j][0];
                int y = meetings[j][1];

                union(x,y);

                list.add(x);
                list.add(y);

                j++;
            }

        
            for(int p : list){
                if(find(p) != find(0)){
                    parent[p] = p; 
                }
            }

            i = j;
        }

        List<Integer> ans = new ArrayList<>();

        for(int k = 0; k < n; k++){
            if(find(k) == find(0)){
                ans.add(k);
            }
        }

        return ans;
    }

    int find(int x){
        if(parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }

    void union(int a, int b){

        int pa = find(a);
        int pb = find(b);

        if(pa != pb){
            parent[pb] = pa;
        }
    }
}