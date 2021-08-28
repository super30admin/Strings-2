// Time Complexity : O(m + n), m -> Length of haystack, n -> Length of needle
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) return 0;
        if(haystack == null || haystack.length() == 0) return -1;

        int m = haystack.length(), n = needle.length(), i = 0;

        while (i < m) {
            if(needle.charAt(0) == haystack.charAt(i)) {
                int j = i + 1;
                int k = 1;

                while(haystack.charAt(j) == needle.charAt(k) && k < m && j < n){
                    k++;
                    j++;
                }
                if(k == n) return i;
            }
            i++;
        }
        return -1;
    }
}