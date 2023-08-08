// Time Complexity : O(m+n)
// Space Complexity:  O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
// first we calculate the longest prefix suffix of the needle string
// then if the characters of both the string are equal we increment both the pointers and if the pointer on the needle reaches to the last index we return i-j 
// if both the characters are not equal and j > 0 then we move to the lps[j-1] to eliminate comparing repeated characters.
// if both the characters are not equal and j == 0, then we can't go back so we need to increment i pointer on the source string;
class Solution {
    public int strStr(String haystack, String needle) {
        int i=0; //source
        int m= haystack.length();
        int n = needle.length();
        int j=0; //pattern
        int lps[] = lps(needle); //O(n)
        while(i<m){
            if(needle.charAt(j)==haystack.charAt(i))
            {
                j++;
                i++;
                if(j==n)
                {
                    return i-j;
                }
            } else if(needle.charAt(j) != haystack.charAt(i) && j>0)
            {
                j=lps[j-1];
            } else if(needle.charAt(j)!=haystack.charAt(i) && j==0)
            {
                i++;
            }
        }
        return -1;
    }
    private int[] lps(String pattern)
    {
       
        int j=0;
        int n = pattern.length();
        int lps[] = new int[n];
        int i=1;
        lps[0]=0;
        while(i<n)
        {
            //case 1
            if(pattern.charAt(j)== pattern.charAt(i))
            {
                j++;
                lps[i]=j;
                i++;
            }
            else if(pattern.charAt(j) != pattern.charAt(i) && j>0 )
            {
                j = lps[j-1];
            }
            else if(pattern.charAt(j) != pattern.charAt(i) && j==0)
            {
                lps[i]=0;
                i++;
            }
        }
        return lps;
    }
}