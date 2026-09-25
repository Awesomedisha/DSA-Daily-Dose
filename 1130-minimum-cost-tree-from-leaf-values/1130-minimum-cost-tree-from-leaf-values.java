class Solution {
    public int mctFromLeafValues(int[] arr) {
        

        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);

        int sum = 0;

        for (int num : arr) {

            // Remove smaller elements
            while (stack.peek() <= num) {

                int mid = stack.pop();

                sum += mid * Math.min(stack.peek(), num);
            }

            stack.push(num);
        }

        // Combine remaining elements
        while (stack.size() > 2) {

            int mid = stack.pop();

            sum += mid * stack.peek();
        }

        return sum;
    }
}
        
    