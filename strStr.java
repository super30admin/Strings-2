// Time complexity = O(n)
// Space complexity = O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach

// KMP algorithm: Uses Sliding window protocol
// It will work when needle has repeated substrings. We create a lps array of needle.
// Index i of haystack always moves forward, we manipulate index j of needle always.
// Case 2 is to find if we find a smaller prefix that matches my suffix.
// We use a lps array to keep a count of repeated occurrences in the needle string.
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        int m = haystack.length();
        int n = needle.length();

        int[] lps = lps(needle);
        int i=0;    // index for haystack
        int j=0;    // index for needle

        while (i<m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j==n) {
                    return i-n;
                }
            }
            else if (haystack.charAt(i) != needle.charAt(j) && j>0) {
                j = lps[j-1];
            }
            else {
                i++;
            }
        }
        return -1;
    }

    private int[] lps(String needle) {
        int n=needle.length();

        int[] lps = new int[n];

        int j=0, i=1;
        lps[0] = 0;

        while (i<n) {
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            }
            else if (needle.charAt(i) != needle.charAt(j) && j>0) {
                j = lps[j-1];
            }
            else {
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
}