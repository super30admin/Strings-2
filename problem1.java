    /**
    Time Complexity : O(M * N)
    Explanation:
    For each index in haystack (M), we try matching the needle (N).
    In worst case (like repeated characters), it checks many characters repeatedly.

    Space Complexity : O(1)
    Explanation:
    No extra space is used.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially got index out-of-bounds error in the while loop.
    Fixed it by ensuring:
        - k < m (haystack boundary)
        - j < n (needle boundary)
    Also needed to break the loop when mismatch occurs.
    */


    class Solution {


        public int strStr(String haystack, String needle) {
    
            int m = haystack.length();
            int n = needle.length();
    
            // Edge case
            if (n == 0) return 0;
    
            for (int i = 0; i <= m - n; i++) {
    
                if (haystack.charAt(i) == needle.charAt(0)) {
    
                    int k = i;
                    int j = 0;
    
                    // Match characters
                    while (k < m && j < n && haystack.charAt(k) == needle.charAt(j)) {
                        k++;
                        j++;
    
                        if (j == n) {
                            return i;
                        }
                    }
                }
            }
    
            return -1;
        }
    }