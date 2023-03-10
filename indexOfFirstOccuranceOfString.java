// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
/* // bruteforce
 * we check the starting characters in both the strings, if we find the 1st character is matching
 * run the loop till we find the complete word in the haystack. 
 * if the needle string is found return the index or else return -1
*/

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int i = 0;
        if (m < n)
            return -1;
        while (i <= m - n) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int k = i;
                int j = 0;
                while (haystack.charAt(k) == needle.charAt(j)) {
                    k++;
                    j++;
                    if (j == n)
                        return i;
                }
            }

            i++;
        }

        return -1;
    }
}

// kmp

// Time Complexity : O(m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three
// sentences only
/*
 * KPM algorithm
 */
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int i = 0, j = 0;
        if (m < n)
            return -1;

        int[] lps = lps(needle);
        while (i < m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == n)
                    return i - n;
            } else if (haystack.charAt(i) != needle.charAt(j) && j > 0) {
                j = lps[j - 1];
            } else if (haystack.charAt(i) != needle.charAt(j) && j == 0) {
                i++;
            }
        }

        return -1;
    }

    private int[] lps(String needle) {
        int[] lps = new int[needle.length()];
        int i = 1, j = 0;
        lps[0] = 0;
        while (i < needle.length()) {
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } else if (needle.charAt(i) != needle.charAt(j) && j > 0) {
                j = lps[j - 1];
            } else if (needle.charAt(i) != needle.charAt(j) && j == 0) {
                lps[i] = 0;
                i++;
            }
        }

        return lps;
    }
}