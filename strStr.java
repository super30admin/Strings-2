// Time Complexity : O(n - l) where n is the length of the string haystack and l is the length of the string needle 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, couldn't code it myself

// Your code here along with comments explaining your approach
// Robin Karp method using longest prefix suffix

class strStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0; 
        int m = haystack.length(), n = needle.length();
        int[] lps = lps(needle, n);
        int i = 0, j = 0;
        while (i < m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if (j == n) {
                return i - n;
            } else if (i < m && j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = lps[j - 1];
            } else if (i < m && j == 0 && haystack.charAt(i) != needle.charAt(j)) {
                i++;
            }
        }
        return -1;
    }
    
    private int[] lps(String pattern, int n) {
        int[] lps = new int[n];
        int i = 1, j = 0;
        lps[0] = 0;
        while (i < n) {
            // case 1
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            }
            // case 2
            else if (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = lps[j - 1];
            }
            // case 3 
            else if (j == 0 && pattern.charAt(i) != pattern.charAt(j)) {
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
}