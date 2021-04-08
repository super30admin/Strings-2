// Time Complexity : O(m+ n) where m and n are lengths of haystack and needle
// Space Complexity :O(n) where n is the length of needle
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public int strStr(String haystack, String needle) {
        
        if(needle==null|| needle.length()==0)
        {
            return 0;
        }
        //to store longest prefix suffix values of the needle
        int[] lps = new int[needle.length()];
        int ans = 0;
        int i=0;
        int j=1;
        //populate the lps
        while(j<needle.length())
        {
            char left = needle.charAt(i);
            char right = needle.charAt(j);
            
            
            if(left == right)
            {
                i++;
                lps[j]=i;
                j++;
            }
             else if(i!=0 && left!=right)
            {
                i = lps[i-1];
            }
            else if(i==0 && left!=right)
            {
                lps[j]=0;
                j++;
            }
        }
        
            int x =0;
            int y=0;
            
            while(x<haystack.length())
            {

              char h = haystack.charAt(x);
              char n = needle.charAt(y);
              //when characters being compares are same keep going to the next characters until we have exhasted the lenght of needle
              if(h==n)
              {
                x++;
                y++;
              
                if(y >= needle.length())
                {
                  //this would give the starting position of the pattern
                  return x-y;
                }
              }
              //go back to the postion on needle until where we matched with haystack
              else if(y != 0 && h != n)
              {
                y = lps[y-1];
              }
              //
              else if(y == 0 && h != n)
              {
                x++;
              }
            }
        return -1;
        
    }
}