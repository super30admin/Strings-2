//Implemented brute force solution for the problem. But it fails in leetcode for one case where if both haystack and needle is "", the output expected is 0 but I get -1
class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack==null||needle==null) return 0;
        for(int i=0;i<haystack.length()-needle.length();i++){
            int j;
            for(j=0;j<needle.length();j++){
                if(haystack.charAt(i+j)!=needle.charAt(j)) break;
            }
            if(j == needle.length()){
                return i;
            }
        }
        return -1;
    }
}