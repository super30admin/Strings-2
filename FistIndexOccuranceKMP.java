class Solution {
    // tc- m*n
     public int strStr(String haystack, String needle) {
         int m = haystack.length();
         int n = needle.length(); // tc -o(m+n)
         if(m<n) return -1;
         int i=0; //haystack
         int j=0; // needle
         int[] lps = lps(needle); 
         while(i<m)
         {
             if(haystack.charAt(i) == needle.charAt(j))
             {
               i++;
               j++;
               if(j == n) return i-n;
             }
             else if(haystack.charAt(i) != needle.charAt(j) && j>0)
             {
                 j = lps[j-1];
             }
             else if(haystack.charAt(i) != needle.charAt(j) && j == 0)
             {
                 i++;
             }
 
         }
         return -1;
 
     }
     private int[] lps(String needle)//tc - o(n), sc-o(len of lps array)
     {
         int[] lps = new int[needle.length()];
         lps[0] = 0;
         int j=0;
         int i=1;
 
         while(i< needle.length())
         {
             if(needle.charAt(j) == needle.charAt(i))
             {
                 j++;//j-> incoming char in specific window i.e j will give length of the longest prefix window
                 lps[i] = j;
                 i++;
             }
             else if(needle.charAt(j) != needle.charAt(i) && j>0)
             {
                 j = lps[j-1];
             }
             else if(needle.charAt(j) != needle.charAt(i) && j==0)
             {
                 lps[i] = 0;
                 i++;
             }
 
         }
      return lps;
     }
 }