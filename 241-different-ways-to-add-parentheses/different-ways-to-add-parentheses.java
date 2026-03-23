class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        


    Map<String, List<Integer>> memo = new HashMap<>();
    
    
        
        
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            
            // agar operator mila
            if (ch == '+' || ch == '-' || ch == '*') {
                
                // left aur right split karo
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);
                
                // recursively solve
                List<Integer> leftResults = diffWaysToCompute(left);
                List<Integer> rightResults = diffWaysToCompute(right);
                
                // combine all possibilities
                for (int l : leftResults) {
                    for (int r : rightResults) {
                        
                        if (ch == '+') result.add(l + r);
                        else if (ch == '-') result.add(l - r);
                        else result.add(l * r);
                    }
                }
            }
        }
        
    
        if (result.size() == 0) {
            result.add(Integer.parseInt(expression));
        }
        
        memo.put(expression, result);
        return result;
    }
}
        
    