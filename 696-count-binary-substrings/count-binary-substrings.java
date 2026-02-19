class Solution {
    public int countBinarySubstrings(String s) {
        

        int prevGroup = 0;   // previous group ka size
        int currGroup = 1;   // current group ka size (start me 1)
        int ans = 0;         // final answer

        // string traverse karo
        for (int i = 1; i < s.length(); i++) {

            // agar same character hai → group badhao
            if (s.charAt(i) == s.charAt(i - 1)) {
                currGroup++;  // current group ka size badh raha hai
            } 
            else {
                // character change ho gaya

                // valid substrings add karo
                ans += Math.min(prevGroup, currGroup);

                // current group ab previous ban jayega
                prevGroup = currGroup;

                // new group start
                currGroup = 1;
            }
        }

        // last pair ke liye add karna zaroori hai
        ans += Math.min(prevGroup, currGroup);

        return ans;
    }
}

        
    
