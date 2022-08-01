// Time Complexity : O(mn) where m is the needle length and n is the haystack length
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

//Problem statement: https://leetcode.com/problems/implement-strstr/

class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}
