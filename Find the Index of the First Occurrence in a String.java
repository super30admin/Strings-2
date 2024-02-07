// Time Complexity : O(n)
// Space Complexity : O(1)
// Method used : KMP algorithm

class Solution {
    public int strStr(String haystack, String needle) {
        
        // This is KMP Pattern matching algorithm
        int m = haystack.length();
        int n = needle.length();

        int[] lps = lps(needle, n);

        int i = 0;// pointer in the haystack
        int j = 0;// pointer in the needle

        while(i < m)
        {
            if(haystack.charAt(i) == needle.charAt(j))
            {
                i++;
                j++;

                // We found the needle and i - n will give the first occurence of the string needle in  
                // haystack
                if(j == n) return i - n;
            }

            // This means haystack.charAt(i) != needle.charAt(j) and j > 0
            else if(j > 0)
            {
                j = lps[j - 1];
            }

            // This means haystack.charAt(i) != needle.charAt(j) and j == 0. In this case just move 
            // variable i forward. This is because we can't move j backwards anymore. So just skip 
            // the step lps[i] = 0 which we did in creating the lps needle array. Here we don't 
            // need to modify lps array because we already have it so just do i++
            else
            {
                i++;
            }
        }

        return -1;
    }

    private int[] lps(String needle, int n)
    {
        int i = 1, j = 0;
        int[] lps = new int[n];

        while(i < n)
        {
            if(needle.charAt(i) == needle.charAt(j))
            {
                j++;
                lps[i] = j;
                i++;
            }

            // This means needle.charAt(i) != needle.charAt(j) and j > 0
            else if(j > 0)
            {
                j = lps[j - 1];
            }

            // This means needle.charAt(i) != needle.charAt(j) and j == 0. In this case just make lps[i] = 0
            else
            {
                lps[i] = 0;
                i++;
            }
        }

        return lps;
    }
}