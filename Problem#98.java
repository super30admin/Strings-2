// Find the Index of the First Occurrence in a String - KMP algorithm

// Time Complexity : O(m+n)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(m < n)
            return -1;
        int i = 0;
        int j = 0;
        int[] lps = lps(needle, n);
        while(i < m){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                if(j == n)
                    return i - n;
            } else if(haystack.charAt(i) != needle.charAt(j) && j > 0){
                j = lps[j-1];
            } else if(haystack.charAt(i) != needle.charAt(j) && j == 0){
                i++;
            }
        }
        return -1;
    }
    private int[] lps(String needle, int n){
        int[] lps = new int[n];
        lps[0] = 0;
        int i = 1;
        int j = 0;
        while(i < n){
            if(needle.charAt(j) == needle.charAt(i)){
                j++;
                lps[i] = j;
                i++;
            } else if(needle.charAt(j) != needle.charAt(i) && j > 0){
                j = lps[j-1];
            } else if(needle.charAt(j) != needle.charAt(i) && j == 0){
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
}