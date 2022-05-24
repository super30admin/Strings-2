//TC : O(m+n) 
//SC :O(n)
class Solution {
    private int[] getLps(String needle) {
        int i = 1;
        int j = 0;
        int[] result = new int[needle.length()];
        //result[0] = 0;
        while (i < needle.length()) {
            char c = needle.charAt(i);
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
                result[i] = j;
                i++;
            } else if (j > 0) {
                j = result[j - 1];
            } else {
                result[i] = 0;
                i++;
            }
        }
        return result;
    }
    public int strStr(String haystack, String needle) {
        if (haystack == null || haystack.length() == 0) return 0;
        if (needle == null || needle.length() == 0) return 0;

        int m = haystack.length();
        int n = needle.length();
        int[] lps = new int[n];
        int i = 0;
        int j = 0;

        lps = getLps(needle);

        while (i < m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == n) return i - j;
            } else if (j == 0) {
                i++;
            } else {
                j = lps[j - 1];
            }
        }
        return -1;
    }
}