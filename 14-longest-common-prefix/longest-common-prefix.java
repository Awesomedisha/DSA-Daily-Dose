class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        
        // edge case: agar array empty hai
        if (strs == null || strs.length == 0) {
            return "";
        }

        // pehla string ko prefix maan lo
        String prefix = strs[0];

        // baaki sab strings se compare karo
        for (int i = 1; i < strs.length; i++) {
            
            // jab tak current string prefix se start nahi hoti
            while (strs[i].indexOf(prefix) != 0) {
                
                // prefix ko chhota karte jao (last char hatao)
                prefix = prefix.substring(0, prefix.length() - 1);
                
                // agar prefix empty ho gaya → no common prefix
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}
        
