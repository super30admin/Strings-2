/*KMP algo
 * TC: O(n) building lps array +  O(m+n) going to both the string
 * sc: O(n) building lps
 * 
 * 
 */

class Solution {
    int[] lps;
    int m, n;

    public int strStr(String haystack, String needle) {

        m = haystack.length();
        n = needle.length();

        lps = new int[n];

        calc(needle); // build the array for needle values

        int i = 0, j = 0;

        while (i < m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;

                if (j == n)
                    return i - j;
            } else if (haystack.charAt(i) != needle.charAt(j) && j > 0) {
                j = lps[j - 1];
            } else if (haystack.charAt(i) != needle.charAt(j) && j == 0) {
                i++;
            }
        }
        return -1;

    }

    private void calc(String s) {
        lps[0] = 0;
        int i = 1, j = 0;

        while (i < n) {
            if (s.charAt(i) == s.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } else if (s.charAt(i) != s.charAt(j) && j > 0) {
                j = lps[j - 1];
            } else if (s.charAt(i) != s.charAt(j) && j == 0) {
                lps[i] = 0; // j
                i++;
            }
        }
    }
}