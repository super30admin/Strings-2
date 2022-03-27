// Time Complexity : O(n+m) where n is len of haystack and m is len of needle
// Space Complexity : O(m) where m is len of needle
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int strStr(String haystack, String needle) {
        
        int[] res = getLPSArr(needle);
        
        int hay = 0;
        int nee = 0;
        
        while (hay < haystack.length() && nee < needle.length()) {
            
            char hayChar = haystack.charAt(hay);
            char neeChar = needle.charAt(nee);
            
            if (hayChar == neeChar) {
                
                hay++;
                nee++;
            }
            
            else {
                
                if (nee == 0) {
                    hay++;
                }
                else {
                    nee = res[nee-1];
                }
            }
        }
        
        if (nee == needle.length()) {
            return hay - needle.length();
        }
        
        return -1;
    }
    
    private int[] getLPSArr(String needle) {
        
        int n = needle.length();
        
        int[] lps = new int[n];

        int left = 0;
        int right = 1;
        
        while (right < n) {
            
            char leftChar = needle.charAt(left);
            char rightChar = needle.charAt(right);
            
            if (leftChar == rightChar) {
                
                lps[right] = left + 1; // till here a string of left+1 is matched
                left++;
                right++;
            }
            
            else {
                
                if (left == 0) {
                    right++;
                }
                else { // checking if any longest prefix or suffix that can be reused
                    left = lps[left - 1]; // move to that point and check if it matches rightChar
                }
            }
        }
        
        return lps;
    }
}