// Time Complexity : O(n * m) where n is the length of the string s and m is the length of the string p
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1. Check if first character of needle is present in haystack and start comparing the rest of the characters.
 * 2. If all the characters match, return the index of the first character of the needle.
 * 3  If the characters don't match, move the pointer to the next character in the haystack and repeat the process.
 * 4. If the needle is not present in the haystack, return -1.
 */

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        if(n > m)
            return -1;

        for(int i=0; i <= m - n; i++){
            int j = 0;
            int k = i;
            while(k < i + n){
                if(haystack.charAt(k) != needle.charAt(j)){
                    break;
                }
                j++;
                k++;
            }

            if(j == n){
                return i;
            }
        }

        return -1;
    }
}