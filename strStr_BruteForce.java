// Time Complexity : O((n-l)*l) where n is the length of the haystack and l is the length of the needle
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Sliding window solution

class strStr_BruteForce  {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0; 
        int l = needle.length(), n = haystack.length();
        for (int i = 0; i <= n - l; i++) {
            if (haystack.substring(i, i + l).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}