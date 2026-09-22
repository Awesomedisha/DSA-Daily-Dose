class Solution {
    public String multiply(String num1, String num2) {
       
        // If either number is 0, answer is 0
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();

        // Maximum possible digits = m + n
        int[] result = new int[m + n];

        // Multiply digit by digit
        for (int i = m - 1; i >= 0; i--) {

            for (int j = n - 1; j >= 0; j--) {

                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';

                int product = digit1 * digit2;

                int pos1 = i + j;
                int pos2 = i + j + 1;

                // Add product to current position
                int sum = product + result[pos2];

                result[pos2] = sum % 10;
                result[pos1] += sum / 10;
            }
        }

        // Convert array to String
        StringBuilder sb = new StringBuilder();

        for (int digit : result) {

            // Skip leading zeros
            if (sb.length() == 0 && digit == 0) {
                continue;
            }

            sb.append(digit);
        }

        return sb.toString();
    }
}
        
    