// Time Complexity : O(m+n) for creating lps and maching string
// Space Complexity : O(m) for creating lps
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        int[] lps = lps(needle);
        int j = 0;
        int i = 0;
        while(i<haystack.length())
        {
            if(j==needle.length())
            {
                return i-j;
            }
            if(haystack.charAt(i)==needle.charAt(j))
            {
                j++;
                i++;
            }
            else
            {
                if(j>0)
                {
                    j = lps[j-1];
                }
                else{
                    i++;
                }
            }
        }
       
        return j!=needle.length()?-1:i-j;
    }
    
    private int[] lps(String s)
    {
        int[] out = new int[s.length()];
        int j = 0;
        int i = 1;
        while(i<s.length())
        {
            //case 1
            if(s.charAt(i)==s.charAt(j))
            {                
                out[i++] = ++j;
            }
            //case 2
             else if(s.charAt(i)!=s.charAt(j) && j>0)
            {
                j = out[j-1];
            }
            //case 3
            else if(s.charAt(i)!=s.charAt(j) && j==0)
            {
                out[i++] =0;
            }
        }
        
        return out;
        
    }
}