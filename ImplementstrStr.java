// Time Complexity : O(m*n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)    return 0;
        
        int index = haystack.indexOf(needle);
        
        return index;
    }
}
