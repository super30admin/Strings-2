// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


class Solution {
    public int strStr(String haystack, String needle) {
        
        int m = haystack.length();
        int n = needle.length();
        int i = 0;
        while(i <= m - n) {
            int j = 0;
            if(haystack.charAt(i) == needle.charAt(j)) {
                int k = i;
                while(haystack.charAt(k) == needle.charAt(j)) {
                    k++;
                    j++;
                    if(j == n) {
                        return i;
                    }
                }
            }
            i++;
        }
        return -1;
    }
}