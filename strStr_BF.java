// 28. Implement strStr() - https://leetcode.com/problems/implement-strstr/
// Time Complexity :  O(MxN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

// Your code here along with comments explaining your approach
// Brute Force

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0)
            return 0;
        if(haystack == null || haystack.length() == 0)
            return -1;
        int m = haystack.length();
        int n = needle.length();
        int i = 0;
        while(i < m){
            if(haystack.charAt(i) == needle.charAt(0)){
                int k = i + 1;
                int j = 1;
                while(k < m && j < n && haystack.charAt(k) == needle.charAt(j)){
                    k++;
                    j++;
                }
                if(j == n)
                    return i;
            }
            i++;
        }
        return -1;
    }
}