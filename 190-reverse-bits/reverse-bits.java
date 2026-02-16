class Solution {
    public int reverseBits(int n) {
        
        int result = 0;

        // Loop through all 32 bits
        for (int i = 0; i < 32; i++) {
            result <<= 1;        // Left shift result by 1 bit (space banate hai)
            result |= (n & 1);   // Last bit of n ko result me add karo
            n >>= 1;             // n ko right shift karo (next bit ready)
        }

        return result;
    }
}

        
    
    
        
    
    

    
    


        
    
