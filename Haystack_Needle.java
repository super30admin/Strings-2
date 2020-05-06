// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        
        if(m < n)
            return -1;
        else if(m == n)
            return haystack.equals(needle)?0:-1;
        else{
            if(haystack.contains(needle)){
                return haystack.indexOf(needle);
            }
        }
        return -1;
    }
}