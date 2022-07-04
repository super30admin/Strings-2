//https://leetcode.com/problems/implement-strstr/
// Time Complexity :O(m*n)  
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class Solution {
    public int strStr(String haystack, String needle) {
        int m=haystack.length();
        int n=needle.length();
        int k=0; //source pointer
        int j=0; //patter pointer
       for(int i=0;i<=m-n;i++)
       {
           for(k=i;k<n+i;k++)
           {
               if(haystack.charAt(k)!=needle.charAt(j))
               {
                  break;
               }
               j++;
           }
           if(j==n)
               return i;
           j=0;
       }
        return -1;
    }
}