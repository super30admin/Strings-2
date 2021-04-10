// Time Complexity : O(n-l * l) n = length of haystack, l = length of needle
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;
        int nlen = needle.length();
        int i = 0, j = nlen - 1;
        int hlen = haystack.length();
        while(i < hlen && j < hlen){
            if(haystack.charAt(i) == needle.charAt(0)){
                int count = 0; int n= 0;
                for(int k = i; k < i+nlen; k++){
                    if(haystack.charAt(k) == needle.charAt(n++)){
                        count++;
                    }
                }
                if(count == nlen)
                    return i;
                i++;j++;
            }else{
                i++; j++;
            }
            
        }
        return -1;
    }
}
