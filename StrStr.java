
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length()==0 && needle.length()==0)
            return 0;
        
        int i=0;
        int n = needle.length();                     
        while(i+n <= haystack.length()){
            String s = haystack.substring(i, i+n);
            if(s.equals(needle)){
                return i;
            }
            i++;
        }
        return -1;
            
    }
}