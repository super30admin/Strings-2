// Time Complexity : O(mn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
Approach
here we are using the brute force solution
we are goiing over all the elements of the haystack and check if first char of the 
needle is matching to it or not, if yes we start another loop to itterate over the rest to check
if it is a match of not if it is we return the starting index else we continue the search
if needle is not found we return -1
*/

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int i = 0;
        while (i <= m - n) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 0;
                int k = i;
                while (haystack.charAt(k) == needle.charAt(j)) {
                    k++;
                    j++;

                    if (j == n) {
                        // all the char matched
                        return i;
                    }
                }
            }
            i++;
        }
        return -1;
    }
}