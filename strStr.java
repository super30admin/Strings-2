//Time Complexity : O(m+n)
//Space Complexity : O(n)
//Did this code run successfully on leetcode: Yes
//Any problem you faced while runnning this code: No
class strStr {
    public int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;
        int[] lps = lps(needle);
        while(i < haystack.length()) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++; j++;
                if(j == needle.length()) {
                    return i-j;
                }
            } else if(haystack.charAt(i) != needle.charAt(j) && j > 0) {
                j = lps[j-1];
            } else if(haystack.charAt(i) != needle.charAt(j) && j == 0) {
                i++;
            }
        }
        return -1;
    }

    private int[] lps(String needle) {
        int n = needle.length();
        int[] lps = new int[n];
        int j = 0;
        int i = 1;
        lps[0] = 0;
        while(i < n) {
            if(needle.charAt(i) == needle.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } else if(needle.charAt(i) != needle.charAt(j) && j > 0) {
                j = lps[j-1];
            } else if(needle.charAt(i) != needle.charAt(j) && j == 0) {
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
}