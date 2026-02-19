class Solution {
    public String decodeString(String s) {
    

        // repeat count store karne ke liye stack
        Stack<Integer> countStack = new Stack<>();

        // previous strings store karne ke liye stack
        Stack<String> stringStack = new Stack<>();

        String currentString = ""; // current decoded part
        int k = 0; // repeat number

        for (char ch : s.toCharArray()) {

            // agar digit hai → number build karo
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0'); 
                // multi-digit numbers handle ho jayenge
            }

            // agar '[' mila → push current state
            else if (ch == '[') {
                countStack.push(k);          // repeat count save
                stringStack.push(currentString); // previous string save

                // reset for new bracket
                k = 0;
                currentString = "";
            }

            // agar ']' mila → decode karo
            else if (ch == ']') {
                int repeatTimes = countStack.pop();
                String prevString = stringStack.pop();

                // currentString ko repeat karo
                StringBuilder temp = new StringBuilder(prevString);

                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(currentString);
                }

                currentString = temp.toString();
            }

            // normal character hai
            else {
                currentString += ch;
            }
        }

        return currentString;
    }
}

        
    