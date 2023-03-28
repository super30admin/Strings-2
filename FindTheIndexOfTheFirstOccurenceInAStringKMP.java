// TC: O(N)
// SC: O(m)
class Solution {
    public int strStr(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();
        if(n < m) {
            return -1;
        }
        // preprocessing
        int[] lps = new int[m];
        int i = 1, prev = 0;
        while(i < m) {
            if(needle.charAt(i) == needle.charAt(prev)) {
                prev++;
                lps[i] = prev;
                i++;
            } else {
                if(prev == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    prev = lps[prev - 1];
                }
            }
        }
        int haystackPointer = 0, needlePointer = 0;
        while(haystackPointer < n) {
            if(haystack.charAt(haystackPointer) == needle.charAt(needlePointer)) {
                needlePointer++;
                haystackPointer++;
                if(needlePointer == m) {
                    return haystackPointer - m;
                }
            } else {
                if(needlePointer == 0) {
                    haystackPointer++;
                } else {
                    needlePointer = lps[needlePointer - 1];
                }
            }
        }
        return -1;
    }
}