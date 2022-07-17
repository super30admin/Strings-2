//Time : O(m*n)
//Space : O(1)

class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;
        while (i <= haystack.length() - needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                int k = i;
                while (haystack.charAt(k) == needle.charAt(j)) {
                    k++;
                    j++;
                    if (j == needle.length())
                        return i;
                }
                j = 0;
            }
            i++;
        }
        return -1;

    }
}

// T: O(m)
// S : O(m)
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (m < n)
            return -1;
        int i = 0;
        int j = 0;
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
        int j = 0;
        int i = 1;
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