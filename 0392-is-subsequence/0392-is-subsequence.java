class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int i = 0; // pointer for s
        int j = 0; // pointer for t

        while (i < s.length() && j < t.length()) {

            // If characters match, move s pointer
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }

            // Always move t pointer
            j++;
        }

        // If we matched all characters of s
        return i == s.length();
    }
}
        
