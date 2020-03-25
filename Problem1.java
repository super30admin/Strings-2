// Problem1  Implement strStr() (https://leetcode.com/problems/implement-strstr/)

//Time comlexity O(hlen (hlen - nlen)) 
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        
        int hlen = haystack.length();
        int nlen = needle.length();
        for(int i = 0; i < hlen - nlen + 1; i++){
             if(haystack.substring(i, i + nlen).equals(needle)) return i;           
        }
        return -1;
    }
}
