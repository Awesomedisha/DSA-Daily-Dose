class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
       int n=rooms.size();
       boolean isvisited[]=new boolean[n];
       dfs(rooms,0,isvisited);
       //check for all rooms
       for(int i=0;i<n;i++){
        if(!isvisited[i]){
            return false;
        }
        
       }
       return true;
    }   
       //dfs function
    private void dfs (List<List<Integer>> rooms,int index,boolean [] isvisited){
        isvisited[index]=true;
        for(int key:rooms.get(index)){
            if(!isvisited[key]){
                dfs(rooms,key,isvisited);
            }

        }
    }
}


        

