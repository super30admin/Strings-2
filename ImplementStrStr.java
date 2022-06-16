//Time: O(haystack length - needle length) * O(needle length) | Space: O(1)
// Brute force soln
class Solution {
    public int strStr(String haystack, String needle) {
        for(int i=0;i<(haystack.length()-needle.length()+1) && haystack.length() >= needle.length();i++) {
            int main = i;
            int pattern = 0;
            // we keep checking all the character from needle in every continous substring made out of haystack of size needle
            while(pattern < needle.length()) {
                if(haystack.charAt(main) == needle.charAt(pattern)) {
                    pattern++;
                    main++;
                } else break;
            }
            // when entire needle is passed, we return the index of i
            if(pattern == needle.length()) return i;
        }
        return -1;
    }
}