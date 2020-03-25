// Time Complexity :O(n^2)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0 && haystack.length()==0) return 0;
        if(needle==null || needle.length()==0) return 0;
        if(haystack.length()<needle.length()) return -1;
        for(int i=0;i<haystack.length();i++){
            if(haystack.charAt(i)==needle.charAt(0) ){
                if(match(i,haystack,needle)) return i;
            }
        }
        return -1;
    }
    
    private boolean match(int index, String haystack,String needle){
        int i=0;
        if(index==haystack.length()-1 && needle.length()!=1) return false;
        while(i<needle.length()){
            if(index>=haystack.length()) return false;
            if(haystack.charAt(index)!=needle.charAt(i)) return false;
        index++;
            i++;
        }
        return true;
    }
}