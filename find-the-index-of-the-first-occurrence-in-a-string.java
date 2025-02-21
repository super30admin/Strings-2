// Time Complexity : O(M * N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // TC = O(n * m), SC = O(1)
    public int strStr(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();       
        for (int i = 0; i <= n - m; i++) { // ensure enough space for needle
            int j = 0;
            if(needle.charAt(j) == haystack.charAt(i)) {
                for (j = 1; j < m; j++) {
                    if (needle.charAt(j) != haystack.charAt(i + j)) {
                        break;
                    }
                }
                if (j == m) {
                    return i;  // Found the substring, return starting index
                }
            }   
        }
        return -1;  // Needle not found in haystack
    }
}