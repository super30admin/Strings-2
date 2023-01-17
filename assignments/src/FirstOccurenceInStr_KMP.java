// Approach: KMP algorithm
// Time: O(m+n)
// Space: O(n) where n = needle Str length

class FirstOccurenceInStr_KMP {
    public int strStr(String haystack, String needle) {
        int[] lps = computeLPS(needle);

        int i = 0;
        int j = 0;
        int n = haystack.length();
        int m = needle.length();

        while(i < n) {
            if(haystack.charAt(i) == needle.charAt(j)){
                i++; j++;
                //end of the needle
                if(j == m) return i - j;
            }
            else {
                if(j > 0) j = lps[j - 1];
                else i = i + 1;
            }
        }
        return -1;
    }

    int[] computeLPS(String needle){
        int[] lps = new int[needle.length()];

        lps[0] = 0;
        int len = 0;
        int i = 1;
        int m = lps.length;
        while(i < m) {
            if(needle.charAt(i) == needle.charAt(len)){
                len += 1;
                lps[i] = len;
                i++;
            }
            else {
                if(len != 0) {
                    len = lps[len - 1];
                }
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}