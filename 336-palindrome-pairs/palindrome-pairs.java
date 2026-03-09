

class Solution {

    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> result = new ArrayList<>();

        // map word -> index
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {

            String word = words[i];

            for (int j = 0; j <= word.length(); j++) {

                String left = word.substring(0, j);
                String right = word.substring(j);

                // CASE 1
                if (isPalindrome(left)) {

                    String revRight = new StringBuilder(right).reverse().toString();

                    if (map.containsKey(revRight) && map.get(revRight) != i) {

                        result.add(Arrays.asList(map.get(revRight), i));
                    }
                }

                // CASE 2
                if (right.length() != 0 && isPalindrome(right)) {

                    String revLeft = new StringBuilder(left).reverse().toString();

                    if (map.containsKey(revLeft) && map.get(revLeft) != i) {

                        result.add(Arrays.asList(i, map.get(revLeft)));
                    }
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String s) {

        int l = 0;
        int r = s.length() - 1;

        while (l < r) {

            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}