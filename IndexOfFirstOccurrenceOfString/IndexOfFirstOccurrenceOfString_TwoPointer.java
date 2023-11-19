/* Time Complexity : O(m*n) 
*   m - length of source string - haystack 
*   n - length of patern string - needle */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(n > m) return -1;
        int p = 0; //start index of the substring being compared
        while(p <= m-n){
            if(haystack.charAt(p) == needle.charAt(0)){
                int p1 = p;//pointer on haystack
                int p2 = 0;//pointer on needle
                //Till chars matches for both strings keep incrementing the pointer
                //pointer on needle equals len of needle, return curr. start index p
                while(haystack.charAt(p1) == needle.charAt(p2)){
                    p1++;
                    p2++;
                    if(p2 == n){
                        return p;
                    }
                }                
            }
            p++;
        }
        return -1;
    }
}