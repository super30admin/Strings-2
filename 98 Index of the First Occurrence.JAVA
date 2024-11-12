// Time Complexity : 0(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    //aesha
    public int strStr(String haystack, String needle) {

        int m = haystack.length();
        int n = needle.length();
        int i = 0;
        while (i <= m - n) {
            int j = 0;
            if (haystack.charAt(i) == needle.charAt(j)) {
                int k = i;
                while(haystack.charAt(k) == needle.charAt(j)) {
                    j++;
                    k++;  
                    if (j == n)
                        return i;
                }
            }
            i++;
        }
        return -1;
    }
}