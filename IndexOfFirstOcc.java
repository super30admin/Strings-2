// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;

        int f = 0, s = 0, res = -1;

        while(f<haystack.length()) {
            char c = haystack.charAt(f);
            if(c == needle.charAt(s)) {
                int i = f;
                while(haystack.charAt(i) == needle.charAt(s)) {
                    if(s == needle.length() - 1) {
                        res = (res == -1) ? f : Math.min(res, f);
                        return res;
                    }
                    if(i == haystack.length() - 1) return res;
                    i++;
                    s++;
                }
                if(res > -1) break;
                s = 0;
                f++;
            } else {
                f++;
            }
        }
        return res;
    }
}