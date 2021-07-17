// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int strStr(String haystack, String needle) {
        int m= haystack.length(); int n= needle.length();
        if(n == 0) return 0;
        int i=0; int j=0;
        int lps[] = lps(needle);
        while(i<m){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++; j++;
                if(j==n) return i-n;
            }else if(haystack.charAt(i) != needle.charAt(j) && j>0){
                j=lps[j-1];
            }else if(haystack.charAt(i) != needle.charAt(j) && j==0){
                i++;
            }
        }
        return -1;
    }
    public int[] lps(String needle){
        int[] lps = new int[needle.length()];
        int j=0; int i=1;
        while(i<needle.length()){
            if(needle.charAt(i) == needle.charAt(j)){
                j++;
                lps[i] = j;
                i++;
            }else if(needle.charAt(i) != needle.charAt(j) && j>0){
                j=lps[j-1];
            }else if(needle.charAt(i) != needle.charAt(j) && j==0){
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
}


