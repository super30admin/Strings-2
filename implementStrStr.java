// Time Complexity : O(m + n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Brute Force:
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        int m = haystack.length(); int n = needle.length();
        int i=0;
        while(i <= m - n){
            if(haystack.charAt(i) == needle.charAt(0)){ //match
                int j = 0; int k = i;
                while(j < n && needle.charAt(j) == haystack.charAt(k)){
                        j++; k++;
                }
                    if( j == n) return i;
                } 
            i++; // regardless of whether mismatch or not
            }
    return -1;
    }
}