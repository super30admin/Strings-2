// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int strStr(String haystack, String needle) {
        
        if(needle == "")
            return 0;
        
      haystack =  haystack.replaceFirst(needle,"_");
        if(haystack.contains("_"))
       return haystack.indexOf("_");
        else return -1;
    }
}