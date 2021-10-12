
//time complexity: O(haystack length)
//space complexity: O(1)

//Using the KMP algorithm for searching the occurrences of a a word
//when a mismatch occurs, the word itself gives sufficient information to determine where the next match could begin, thus bypassing re-examination of previously matched characters

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] kmp = new int[needle.length()];
        computeKMP(needle, kmp);
        int i = 0, j = 0;//i is for haystack and j is for needle
        while (i < haystack.length()) {
            if (j == -1) {
                j = 0;
                i ++;
                continue;
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == needle.length() -1) {
                    return i - needle.length() + 1;
                }
                i ++;
                j ++;
            }
            else {
                j = kmp[j];
            }
        }
        return -1;
    }
    private void computeKMP(String s, int[] kmp){
        int prefixEnd = -1;
        int suffixEnd = 0;
        kmp[0] = -1;
        //while loop updates kmp[suffixEnd + 1]
        while (suffixEnd < s.length() - 1) {
            if (prefixEnd == -1 || s.charAt(prefixEnd) == s.charAt(suffixEnd)) {
                kmp[suffixEnd +1] = prefixEnd + 1;
                prefixEnd ++;
                suffixEnd ++;
            }
            else {
                prefixEnd = kmp[prefixEnd];   
            }
        }
    }
}
