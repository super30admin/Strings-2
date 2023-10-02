//                   LPS       Match      Total
// Time Complexity:  O(n)       O(m)      O(m+n)
// Space Complexity: O(n)       O(1)       O(n)
// where m = length of haystack, n = length of needle

class StrStr {
    public int strStr(String haystack, String needle) {

        int[] lps = getLPSarr(needle);
        int i=0;
        int j=0;

        while(i < haystack.length() && j < needle.length()) {
            char hChar = haystack.charAt(i);
            char nChar = needle.charAt(j);

            if(hChar == nChar) {
                i++;
                j++;
            }
            else {
                if(j == 0) {
                    i++;
                }
                else {
                    j = lps[j-1];
                }
            }
        }

        if(j == needle.length()) {
            return i - j;
        }
        return -1;
    }

    private int[] getLPSarr(String needle) {                      // Longest Prefix Suffix array
        int[] lps = new int[needle.length()];
        int l = 0;
        int r = 1;
        while(r < needle.length()) {
            char lChar = needle.charAt(l);
            char rChar = needle.charAt(r);

            if(lChar == rChar) {
                lps[r] = l + 1;
                l++;
                r++;
            }
            else {
                if(l == 0) {
                    r++;
                }
                else {
                    l = lps[l-1];
                }
            }
        }
        return lps;
    }
}



// ******************** BRUTE FORCE APPROACH ********************
//                   LPS
// Time Complexity:  O(m*n)
// Space Complexity: O(1)
// where m = length of haystack, n = length of needle

class Solution {
    public int strStr(String haystack, String needle) {

        if(haystack.length() >= needle.length()) {
            for(int i=0; i<haystack.length()-needle.length()+1; i++) {
                int j=0;
                while(j < needle.length() && haystack.charAt(i+j) == needle.charAt(j)) {
                    j++;
                }
                if(j==needle.length())
                    return i;
            }
        }

        return -1;
    }
}
