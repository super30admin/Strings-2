// Time Complexity : O(m*n) where m and n are the lengths of two Strings.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : We maintain two pointers each on both strings. Check character by character and increment the pointers. If match not found
// increment i and continue the same until m-n.

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int i = 0;
        while(i <= m-n){
            int k = i; //pointer on haystack
            int j = 0; //pointer on needle
            while(k < m && j < n && haystack.charAt(k) == needle.charAt(j)){  //matched
                j++; //increment pointer on haystack
                k++; //increment pointer on haystack
            }
            if(j == n){ //match found
                return i;
            }
            i++;

        }
        return -1;
    }
}
