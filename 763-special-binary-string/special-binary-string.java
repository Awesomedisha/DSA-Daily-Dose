class Solution {
    public String makeLargestSpecial(String s) {
        



        List<String> parts = new ArrayList<>();

        int count = 0;
        int start = 0;

        // string ko primitive special substrings me todna
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '1') count++;
            else count--;

            // ek special block mil gaya
            if (count == 0) {

                // andar ka part recursively solve karo
                String inner = s.substring(start + 1, i);
                String processed = makeLargestSpecial(inner);

                // wrap again with 1 and 0
                parts.add("1" + processed + "0");

                start = i + 1;
            }
        }

        // descending order me sort (important greedy step)
        Collections.sort(parts, Collections.reverseOrder());

        // sabko join karo
        StringBuilder result = new StringBuilder();
        for (String part : parts) {
            result.append(part);
        }

        return result.toString();
    }
}
        
    