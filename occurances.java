// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(n > m) return -1;
        int i = 0;
        while( i <= m - n){
            if(haystack.charAt(i) == needle.charAt(0)){
                int j = 0;
                int k = i;
                while(haystack.charAt(k) == needle.charAt(j)){
                    k++; j++;
                    if(j==n){
                        return i;
                    }
                }
            }
            i++;
        }
        return -1;
    }
}