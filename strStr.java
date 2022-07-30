/*
This solution for implementing the strStr uses the Knuth-Morris-Pratt algorithm for pattern matching, wherein
we generate an array that records the longest common prefix and suffix that can be generated for each location
in the needle. Using this array, whenever we check for the matching strings and come upon unmatching variables,
we save time by restarting the matching from whichever point had the previous longest match, instead of starting
from scratch, or by skipping the check entirely if there were no common matching prefix and suffix previously.
The naive solution uses O(m * n) time to compute

Did this code run on leetcode: yes
*/
class Solution {
    //Time Complexity: O(m + n)
    //Space Complexity: O(n) length of the needle strings lps array
    public int strStr(String haystack, String needle) {
        
        if(needle.length() == 0 || needle == null)
            return 0;
        
        int m = haystack.length();
        int n = needle.length();
        int i = 0; //haystack indicator
        int j = 0; //needle indicator
        int[] lps = kmp(needle);
        
        while(i < m)
        {
            if(haystack.charAt(i) == needle.charAt(j))
            {
                i++;
                j++;
                if(j == n)
                    return i - n;
            }
            //Go to previous longest common match and resume checking from that point
            else if(haystack.charAt(i) != needle.charAt(j) && j > 0)
            {
                j = lps[j - 1];
            }
            //Restart the checking if there is no previous longest common match
            else if(haystack.charAt(i) != needle.charAt(j) && j == 0)
            {
                i++;
            }
            
        }
        
        return -1;
        
    }
    
    private int[] kmp(String needle)
    {
        int[] lps = new int[needle.length()];
        int i = 0; //prefix indicator
        int j = 1; //suffix indicator
        lps[0] = 0;
        
        while(j < needle.length())
        {   //If the prefix so far matches the suffix so far, then we increment both the indicators, 
            //and store the value of the LPS at the current location of the prefix indicator
            if(needle.charAt(i) == needle.charAt(j))
            {
                i++;
                lps[j] = i;
                j++;
            }
            //If the indicators do not match, but we have a partially matching string so far, 
            //we go to the LPS at the location before the current prefix location, to continue checking
            else if(needle.charAt(i) != needle.charAt(j) && i > 0)
            {
                i = lps[i - 1];
            }
            //If the indicators do not match, and we do not have even a partially matching string so far,
            //We set the LPS at 0 at the current location of the suffix indicator and move on to the next element
            else if(needle.charAt(i) != needle.charAt(j) && i == 0)
            {
                lps[j] = 0;
                j++;
            }
        }
        
        return lps;
    }
}