// Time Complexity : O(n) where n is the no of characters in the hayStack.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Implemented using rolling hash
class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;
        int needle_len = needle.length();
        long needle_hash = 0;
        int base = 26;
        long basePowLen = 1;
        long hay_hash = 0;
        for(int i=0; i<needle_len; i++)
        {
            hay_hash = hay_hash * 26 + (haystack.charAt(i) - 'a');
            needle_hash = needle_hash * base + (needle.charAt(i) - 'a');
            basePowLen = basePowLen * base;
        }
        int start = 0;
        int end = needle_len;
        while(end < haystack.length())
        {
            if(hay_hash == needle_hash)
                return start;
            hay_hash = hay_hash * 26 - (basePowLen * (haystack.charAt(start)-'a'));
            hay_hash += (haystack.charAt(end) -'a');
            start++;
            end++;
        }
        if(hay_hash == needle_hash)
                return start;
        return -1;
    }
}