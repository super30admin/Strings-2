// Time Complexity - O(m+n) where m is the length of haystack and n is the length of needle
// Space Complexity - O(n) where n is the length of needle ; space used by lps array
// This Solution worked on LeetCode


class Solution {
    public int strStr(String haystack, String needle) {
        int i=0;
        int j=0;
        int m = haystack.length();
        int n = needle.length();
        if (n==0) return 0;
        int[] lps = lps(needle, n);
        while(i < m){
            //Case 1
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;j++;     
            }
            if(j == n)
                return i-j;
            // Case 2
            else if(i< m && j > 0 && haystack.charAt(i) != needle.charAt(j)){
                j = lps[j-1];
            }
            // Case 3
            else if(i < m && haystack.charAt(i) != needle.charAt(j)){
                i++;
            }    
        }
        return -1;
    }
    private int[] lps(String pattern , int n){
        int i = 1;
        int j = 0;
        int[] lps = new int[n];
        lps[0] = 0;
        while(i < n){
            //Case 1
            if(pattern.charAt(i) == pattern.charAt(j)){
                j++; 
                lps[i] = j; 
                i++;    
            }
            // Case 2
            else if(j > 0 && pattern.charAt(i) != pattern.charAt(j)){
                j = lps[j-1];
            }
            // Case 3
            else if(pattern.charAt(i) != pattern.charAt(j)){
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
}
