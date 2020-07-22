// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * https://leetcode.com/problems/implement-strstr/
 *
 *
 */
class Solution {
	
	//brute force m*n solution
    public int strStr(String haystack, String needle) {
      
        if(needle == null || needle.length() == 0) return 0;
        
        if(needle.length() > haystack.length()) return -1;
        
        for(int i=0; i< haystack.length() - needle.length() + 1; i++){
            if(haystack.charAt(i) == needle.charAt(0)) {
                
                int temp = i+1;
                int j=1;
                for(; j< needle.length() && temp < haystack.length(); j++,temp++){
                    if(haystack.charAt(temp) != needle.charAt(j)){
                        break;
                    }
                }
                
                if(j == needle.length()){
                   return i; 
                }
            }
        }
        
        return -1;
    }
}