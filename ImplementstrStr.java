// Time Complexity : O((n1 - n2)*n2) n1 = length of haystack, n2 = length of needle
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)    return 0;
        
        int index = -1;
        int hPtr = 0, nPtr = 0, count = 0;
        int len1 = haystack.length(), len2 = needle.length();
        int nCnt = 0;
        
        while(hPtr < len1 - len2 + 1){
            
            while(hPtr < len1 - len2 + 1 && 
                  haystack.charAt(hPtr) != needle.charAt(nPtr)){
                hPtr++;
            }
            
            
            while(hPtr < len1 && nPtr < len2
                 && haystack.charAt(hPtr) == needle.charAt(nPtr)){
                hPtr++;
                nPtr++;
                nCnt++;
            }
            
            if(nCnt == len2)    return hPtr - len2;
            
            hPtr = hPtr - nCnt + 1;
            
            nCnt = 0;
            nPtr = 0;
            
        }
        
        return index;
    }
}
