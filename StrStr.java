// Time Complexity: O(m * n), n -> len of needle, m -> len of haystack
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach:
// 1. For all possible substrings in haystack, check if it's equal to needle
// 2. Do not create a new substring each time, use the ptr to compare char in haystack and needle

public class StrStr {
    public int strStr(String haystack, String needle) {
        int hlen = haystack.length();
        int nlen = needle.length();
        for(int i=0; i<=hlen - nlen; i++) {
            char c = haystack.charAt(i);

            if(isStrStr(haystack, needle, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isStrStr(String haystack, String needle, int idx) {

        for(int i=0; i<needle.length(); i++) {
            if(haystack.charAt(idx++) != needle.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
