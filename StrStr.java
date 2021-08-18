// Time Complexity : O(m + n), m -> Length of haystack, n -> Length of needle
// Space Complexity : O(n)
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        if(haystack.length() < needle.length()) return -1;
        
        int[] lps = lps(needle);
        
        int i=0, j=0, m = haystack.length(), n = needle.length();
        
        while(i < m) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                j++;
                i++;
                if(j == n) return i-n;
            }
            else {
                if(j>0) {
                    j = lps[j-1];
                }else if(j==0) {
                    i++;
                }
            }
        }
        
        return -1;
    }
    
    private int[] lps(String needle) {
        int[] lps = new int[needle.length()];
        int i=1, j=0;
        
        while(i<needle.length()) {
            //i and j are equal
            if(needle.charAt(i) == needle.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            }
            //i and j not equal and j>0
            else {
                if(j>0) {
                    j = lps[j-1];
                }else if(j==0) {
                    lps[i] = 0;
                    i++;
                }
            }
            //j==0
        }
        
        return lps;
    }
}