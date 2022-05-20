// Time Complexity : O(length of haystack + length of needle)
// Space Complexity : O(length of needle)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {

    //code2 : KMP algorithm
    
    public int strStr(String haystack, String needle) {

        int m = haystack.length();
        int n = needle.length();

        if(n > m)
            return -1;

        int i=0; //haystack
        int j=0; //needle

        int[] lps = lps(needle);

        while(i < m)
        {
            if(haystack.charAt(i) == needle.charAt(j))
            {
                i++;
                j++;
                if(j == n)
                    return i - n;
            }
            else if (haystack.charAt(i) != needle.charAt(j) && j>0)
            {
                j = lps[j-1];
            }
            else if (haystack.charAt(i) != needle.charAt(j) && j==0)
            {
                i++;
            }
        }

        return -1;

    }

    private int[] lps(String s)
    {
        int[] lps = new int[s.length()];
        int i=1;
        int j=0; //prefix window

        while(i < s.length())
        {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);

            if(c1 == c2)
            {
                j++;
                lps[i] = j;
                i++;
            }
            else if (c1 != c2 && j>0)
            {
                j = lps[j-1];
            }
            else if (c1 != c2 && j==0)
            {
                lps[i] = 0;
                i++;
            }
        }

        return lps;
    }
}
