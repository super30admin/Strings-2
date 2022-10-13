class Solution {
    // tc- m*n
     public int strStr(String haystack, String needle) {
         int m = haystack.length();
         int n = needle.length();
 
         int i=0; //haystack
         int j=0; // needle
 
         while(i <= m-n)
         {
             if(haystack.charAt(i) == needle.charAt(j))
             {
                 int k = i;
                 while(haystack.charAt(k) == needle.charAt(j))
                 {
                 k++;
                 j++;
                 if(j == n) return i;
                 }
                j=0;
             }
             i++;
             
         }
         return -1;
     }
 }