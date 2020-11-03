// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, 0ms
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// identify the first element and then iterate over the remaining elements to validate if entire needle string is present

class Solution {
    public int strStr(String haystack, String needle) {
        
        if (needle.length() == 0) {
            return 0; 
        }
        
        if (haystack.length() == 0) {
            return -1; 
        }
    
        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() - 1 >= haystack.length()) {
                return -1; 
            }
            
            if (haystack.substring(i, needle.length() + i).equals(needle)) {
                return i; 
            }
        }
        
        return -1; 
    }
}