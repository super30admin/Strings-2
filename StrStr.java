// Time Complexity : O(m+n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach 

// We use kmp algorithm to solve this
// We create an lps array using the needle string
// Then we make use of sliding window to compare the characters in haystack and needle
// if we find the mactch then return the start index

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0)
            return 0;
        int m = haystack.length();
        int n = needle.length();
        int[] lps = lps(needle);
        int i = 0;
        int j = 0;
        while (i < m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == n)
                    return i - n;

            } else if (haystack.charAt(i) != needle.charAt(j) && j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }

        }
        return -1;
    }

    public int[] lps(String needle) {
        int n = needle.length();
        int[] lps = new int[n];
        int j = 0;
        int i = 1;
        lps[0] = 0;
        while (i < n) {
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } else if (needle.charAt(i) != needle.charAt(j) && j > 0) {
                j = lps[j - 1];
            } else {
                lps[i] = 0;
                i++;
            }

        }
        return lps;
    }
}
