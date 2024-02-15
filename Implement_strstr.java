// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yess
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach:
class Solution {
    public int strStr(String haystack, String needle) {
        int str1= haystack.length();
        int str2= needle.length();
        for(int i=0; i<(str1-str2)+1;i++){
            if(haystack.charAt(i)== needle.charAt(0)){
                if(haystack.substring(i,str2+i).equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }
}