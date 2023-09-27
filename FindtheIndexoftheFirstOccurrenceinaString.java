class Solution {
    public int strStr(String haystack, String needle) {

        int i = 0;
        int j = 0;
        int m = haystack.length();
        int n = needle.length();
        int[] lps = lps(needle);

        while (i < m) {
            if (needle.charAt(j) == haystack.charAt(i)) {
                i++;
                j++;
                if (j == n) {
                    return i - n;
                }
            } else if (j > 0) {
                j = lps[j - 1];
            } else if (j == 0) {
                i++;
            }
        }
        return -1;
    }

    private int[] lps(String needle) {
        int n = needle.length();
        int j = 0;
        int[] lps = new int[n];
        int i = 1;
        lps[0] = 0;
        while (i < n) {
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
                lps[j] = lps[i];
                i++;
            } else if (j > 0) {
                j = lps[j - 1];

            } else if (j == 0) {
                lps[i] = 0;
                i++;

            }
        }
        return lps;

    }
}
