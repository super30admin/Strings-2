//Time complexity O(m+n)
//Space complexity O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    public int strStr(String haystack, String needle) {
      
        if(needle.length() == 0){
            
            return 0;
        }
        int[] lpsNeedle = new int[needle.length() - 1];
      lpsNeedle = lps(needle);  
        int m = haystack.length();
        
        int i = 0; //haystack
        int j = 0; //needle
        int n = needle.length();
        
        while(i < m){
            
            if(haystack.charAt(i) == needle.charAt(j)  ){
                i ++;
                j ++;
                if(j == n){
                    
                    return i - j;
                }
                
            }
            
             else if(haystack.charAt(i) != needle.charAt(j) && j > 0 ){
                
                j = lpsNeedle[j-1];
                
            }
             else if(haystack.charAt(i) != needle.charAt(j) && j == 0 ){
                
           
                i ++;
                
            } 
        }
       return -1; 
    }
    
    private int[] lps(String pattern){
        
        int i = 1;
        int j = 0;
        int n = pattern.length();
        int[] LPS = new int[n];
        while(i < n){
            
            if(pattern.charAt(i) == pattern.charAt(j) ){
                
                j ++;
                LPS[i] = j;
                i ++;
                
            }
            
             else if(pattern.charAt(i) != pattern.charAt(j) && j > 0 ){
                
                j = LPS[j-1];
                
            }
             else if(pattern.charAt(i) != pattern.charAt(j) && j == 0 ){
                
            LPS[i] = 0;
                i ++;
                
            }
        }
        return LPS;
    }
}