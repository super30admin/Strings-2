// Time Complexity : O(N) is the length of haystack
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        if (haystack == null || haystack.length() == 0 || needle == null || haystack.length() < needle.length())
            return -1;

        if (haystack.contains(needle))
            return haystack.indexOf(needle);
        return -1;
    }
}