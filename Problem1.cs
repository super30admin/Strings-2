
// Time Complexity : O(n+m) to find needle in haystack and O(m) to build LPS 
// Space Complexity : O(m) for the lps array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I perform KMP algorithm to search for needle in haystack. I build the LPS array and traverse through characters of haystack. If both character at ith index of haystack and jth index of needle are equal, 
I increment i & j. If j becomes equal to needle.Length, I return i-m. If the characters are not equal and j>0, I set j to lps[j-1] else I just increment i.
*/
public class Solution
{
    public int StrStr(string haystack, string needle)
    {
        // KMP Algorithm
        int n = haystack.Length;
        int m = needle.Length;

        int[] lps = LowestPrefixSuffix(needle);

        int i = 0, j = 0;

        while (i < n)
        {
            if (haystack[i] == needle[j])
            {
                i++;
                j++;

                if (j == m)
                {
                    return i - m;
                }
            }

            else if (haystack[i] != needle[j] && j > 0)
            {
                j = lps[j - 1];
            }

            else
            {
                i++;
            }
        }

        return -1;
    }

    public int[] LowestPrefixSuffix(string needle)
    {
        int m = needle.Length;
        int[] lps = new int[m];

        int i = 1, j = 0;

        while (i < m)
        {
            if (needle[i] == needle[j])
            {
                j++;
                lps[i] = j;
                i++;
            }

            else if (j > 0)
            {
                j = lps[j - 1];
            }

            else
            {
                lps[i] = 0;
                i++;
            }
        }

        return lps;
    }
}