public class FindIndexFirstOccurrenceString {

// Time Complexity : O(MN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

    class BruteforceSolution {
        public int strStr(String haystack, String needle) {
            int i = 0;
            int m = needle.length();
            int n = haystack.length();
            while (i <= n - m) {
                if (haystack.charAt(i) == needle.charAt(0)) {
                    int a = i, b = 0;
                    while (b < m && (haystack.charAt(a) == needle.charAt(b))) {
                        a++;
                        b++;
                    }
                    if (b == m)
                        return i;
                }
                i++;
            }
            return -1;
        }
    }

// Time Complexity : O(M+N)
// Space Complexity : O(M)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

    class KMPSolution {
        public int strStr(String haystack, String needle) {
            int i = 0, j = 0;
            int[] lps = calcLps(needle);
            if (haystack.length() < needle.length()) {
                return -1;
            }
            while (i < haystack.length()) {
                if (needle.charAt(j) == haystack.charAt(i)) {
                    j++;
                    i++;
                    if (j == needle.length()) {
                        return i - needle.length();
                    }
                } else if ((needle.charAt(j) != haystack.charAt(i)) && j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
            return -1;
        }

        private int[] calcLps(String n) {
            int[] lps = new int[n.length()];
            int i = 0, j = 0;
            lps[0] = 0;
            i++;
            while (i < n.length()) {
                if (n.charAt(i) == n.charAt(j)) {
                    j++;
                    lps[i] = j;
                    i++;
                } else if ((n.charAt(i) != n.charAt(j)) && j > 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
            return lps;
        }
    }
}
