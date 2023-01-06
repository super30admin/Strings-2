//Time complexity is O(n-k) n is length of haystack, k is length of needle
//Space complexity is O(1)
class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.equals(needle))
        {
            return 0;
        }
        for(int i=0;i<=haystack.length()-needle.length();i++){
            String sub = haystack.substring(i, i+needle.length());
            if(sub.equals(needle)){
                return i;
            }
        }
        return -1;
    }
}