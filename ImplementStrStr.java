// Time Complexity : O(m + n) --> where n is the length of input haystack string and m is the length of input needle string
// Space Complexity : O(m)
// Did this code successfully run on Leetcode (28): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    int m; int n;
    public int strStr(String haystack, String needle) {
        this.m = haystack.length();
        this.n = needle.length();
        
        // edge case
        if (n == 0) return 0;
        
        int i = 0; int j = 0;
        int lps[] = lps(needle);
        
        while (i < m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if (j == n) return i - n;
            if (i < m && j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = lps[j-1];
            }
            if (i < m && j == 0 && haystack.charAt(i) != needle.charAt(j)) {
                i++;
            }
        }
        return -1;
    }
    
    private int[] lps(String needle) {
        int lps[] = new int[n];
        lps[0] = 0;
        int i = 1; int j = 0;
        while (i < n) {
            // case 1: when characters are equal
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            }
            else if (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = lps[j - 1];
            }
            else if (j == 0 && needle.charAt(i) != needle.charAt(j)) {
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
}