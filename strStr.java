// Time Complexity : O(N * M) where N is the number of characters in the haystack and M in needle
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
1. Loop throught the two string and get the matching pairs using 2 loops
*/

// Your code here along with comments explaining your approach
class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle.length() > haystack.length())
            return -1;
            
        if(needle == null || needle.length() == 0) 
            return 0;
            
        for(int i=0; i<=haystack.length()-needle.length(); i++) {
            int j;
            for(j = 0;j<needle.length();j++) {
                if(needle.charAt(j) != haystack.charAt(i + j))
                    break;
            }
            if(j == needle.length()) 
                return i;
        }
        return -1;
    }
}
