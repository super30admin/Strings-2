    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/implement-strstr/
    Time Complexity for operators : o(n+c) c is some little constant
    Extra Space Complexity for operators : o(n) .. for LPS array
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : two for loops.
        # Optimized approach: 
                              
            # 1. 
                    A) 
    */  

class Solution {
    public int strStr(String haystack, String needle) {
        
        if(needle.length()==0){
            return 0;
        }
        
        int[] LPS = calc_LPS(needle);
        
        int i = 0;
        int j = 0;
        
        while(i < haystack.length()){
            
            char char_i = haystack.charAt(i);
            char char_j = needle.charAt(j);
            // case 1
            if(char_i == char_j){
                i += 1;
                j += 1;
            }
            
            // case 2
            if(j == needle.length()){
                return i-j;
            }
            
            // case 3
            else if(j>0 && char_i != char_j){
                j = LPS[j-1];    
            }
            
            // case 4
            
            else if(j == 0 && char_i != char_j){
                i += 1;
            }
        }
        
        return -1;
    }
    
    private int[] calc_LPS(String needle){
        int[] LPS = new int[needle.length()];
        LPS[0] = 0;

        int i = 1;
        int j = 0;
        while(i < needle.length()){
            char char_i = needle.charAt(i);
            char char_j = needle.charAt(j);
            
            // case 1
            if(char_i == char_j){
                j += 1;
                LPS[i] = j;
                i += 1;
            }
            
            // case 2
            else if(j > 0 && char_i != char_j){
                j = LPS[j-1];
            }
            
            // case 3
            else if(j==0 && char_i != char_j){
                LPS[i] = 0;
                i += 1;
            }
        }
        return LPS;
    }
}