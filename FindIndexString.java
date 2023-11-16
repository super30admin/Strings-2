// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class FindIndexString {
    class Solution {
     public int strStr(String haystack, String needle) {
         int hLen = haystack.length();
         int nLen = needle.length();
         if(nLen > hLen) return -1;

         for(int  i = 0; i < hLen; i++){
             char c = haystack.charAt(i);
             if(c == needle.charAt(0)){
                 int j = 0;
                 int k = i;
                 while(j < nLen && k < hLen){
                     if(needle.charAt(j) != haystack.charAt(k)){
                         break;
                     }
                     j++;
                     k++;
                 }
                 if(j == nLen)
                     return i;
             }
         }
         return -1;
     }
 }
}
