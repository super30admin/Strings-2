// TC : O(m*n) -> m, n -> length of strings haystack and needle
// SC:  O(1)
// Did it run successfully on Leetcode? : Yes
class Solution {
    public int strStr(String haystack, String needle) {
        if ( haystack == null || needle == null || needle.length() == 0) 
            return 0;
        if ( needle.length() > haystack.length()) 
            return -1;
        
        int i = 0;
        int m = haystack.length();
        while ( i < m - needle.length() + 1 )
        {
            if (haystack.charAt(i) == needle.charAt(0))
            {
                int j = i;
                int k = 0;
                while ( j < m  && k < needle.length())
                {
                    if (k < needle.length() && haystack.charAt(j) == needle.charAt(k))
                    {
                        j++;
                        k++;
                        if ( k == needle.length())
                           return i;
                    }
                    else
                        break;
                }
            }
            i++;
        }
        return -1;
  }
}


