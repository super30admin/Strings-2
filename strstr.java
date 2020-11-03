// Time Complexity : O((N-L)*L), worst case end up checking L-1 chars (needle.length()-1) for N-L-1 chars in haystack
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// maintain a sliding window starting from index 0, compare first chars from haystack and needle, if equal proceeed to check all chars
// if mismatch check increase sliding window index


class Solution {
    public int strStr(String haystack, String needle) {
        if(needle==null || needle.length()==0) return 0;
        
        int h = haystack.length();
        int n = needle.length();
        
        for(int startIdx=0; startIdx<=h-n; startIdx++){
            if(haystack.charAt(startIdx)==needle.charAt(0)){
                int i = startIdx;
                int j = 0;
                while(haystack.charAt(i)==needle.charAt(j)){
                    i++; 
                    j++;
                    if(j==needle.length()){
                        return startIdx;
                    }
                }
            }
        }
        
        return -1;
    }
    
}