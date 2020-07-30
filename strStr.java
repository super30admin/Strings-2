// Time Complexity : O(m+n) m and n are lengths of strings
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;
        int m = haystack.length();
        int n = needle.length();
        int i=0;
        int j=0;
        if(n==0) return 0;
        int[] lps = lps(needle);
        while(i<m){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }
            if(j==n){
                return i-n;
            }
            if(i<m && j > 0 && haystack.charAt(i)!=needle.charAt(j)){
                j = lps[j-1];
            }
            if( i<m && j==0 && haystack.charAt(i)!=needle.charAt(j)){
                i++;
            }
           
        }
        
         return -1;
        }
        
        private int[] lps(String needle){
            int[] lps = new int[needle.length()];
            lps[0] = 0;
            int i = 1;
            int j = 0;
        
        //Building lps
        while(i!=needle.length()){
            if(needle.charAt(i) == needle.charAt(j)){
                j++;
                lps[i] = j;
                i++;
                
            }
            else if(j>0 && needle.charAt(i) != needle.charAt(j)){
                j = lps[j-1];
            }
            else if (j==0 && needle.charAt(i) != needle.charAt(j)){
                lps[i] = 0;
                i++;
            }
           
        }
        
        return lps; 
    }
}