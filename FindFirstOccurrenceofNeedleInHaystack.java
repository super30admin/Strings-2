// KMP Algorithm Approach
// Time Complexity : O(n+m) ~ O(n) since n>m, where n is haystack length and m is needle length,
// Space Complexity : O(m),
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
class Solution {
    public int strStr(String haystack, String needle) {
        int[] lps = lps(needle);
        int i = 0, j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length()) {
                    return i - j;
                }
            } else if (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = lps[j - 1];
            } else if (j == 0 && haystack.charAt(i) != needle.charAt(j)) {
                i++;
            }
        }
        return -1;
    }

    public int[] lps(String needle) {
        int[] lps = new int[needle.length()];
        lps[0] = 0;
        int i = 1, j = 0;
        while (i < needle.length()) {
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } else if (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = lps[j - 1];
            } else if (j == 0 && needle.charAt(i) != needle.charAt(j)) {
                lps[j] = 0;
                i++;
            }
        }
        return lps;
    }
}

// Brute Force Approach
// Time Complexity : O(n*m),
// Space Complexity : O(1),
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.equals(haystack))
            return 0;
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
                if (j == needle.length()) {
                    return i - j + 1;
                }
            } else {
                i = i - j;
                j = 0;
            }
        }
        return -1;
    }
}