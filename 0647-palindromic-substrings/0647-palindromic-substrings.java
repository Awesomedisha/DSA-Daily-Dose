class Solution {
    public int countSubstrings(String s) {
        
        int count = 0;

        // Every character can be the center
        // of an odd-length palindrome.
        for (int i = 0; i < s.length(); i++) {

            // Odd-length palindrome
            count += expand(s, i, i);

            // Even-length palindrome
            count += expand(s, i, i + 1);
        }

        return count;
    }


    private int expand(String s, int left, int right) {

        int count = 0;

        // Keep expanding while:
        // 1. left is inside the string
        // 2. right is inside the string
        // 3. both characters are equal
        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            // We found one palindromic substring.
            count++;

            // Expand one step to the left
            // and one step to the right.
            left--;
            right++;
        }

        return count;
    }
}
        
    