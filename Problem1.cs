public class FindFirstOccurenceString
    {
        // Time Complexity : O(m + n), where m is the length of source stringa and n is the length of pattern string
        // Space Complexity : O(n) - for lps array of pattern
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        public int StrStr(string haystack, string needle)
        {
            int m = haystack.Length;
            int n = needle.Length;
            if (n > m) return -1;
            int[] lps = FindLpsArray(needle);
            int i = 0;//haystack
            int j = 0;//needle
            while (i < m)
            {
                if (haystack[i] == needle[j])
                {
                    i++;
                    j++;
                    if (j == n)
                    {
                        return i - n;
                    }
                }
                else if (j > 0 && haystack[i] != needle[j])
                {
                    j = lps[j - 1];
                }
                else if (j == 0 && haystack[i] != needle[j])
                {
                    i++;
                }
            }
            return -1;
        }

        private int[] FindLpsArray(string needle)
        {
            int[] lps = new int[needle.Length];
            lps[0] = 0;
            int i = 1;
            int j = 0;

            while (i < needle.Length)
            {
                char chi = needle[i];
                char chj = needle[j];

                if (chj == chi)
                {
                    j++;
                    lps[i] = j;
                    i++;
                }
                else if (j > 0 && chj != chi)
                {
                    //best possible squeeze
                    j = lps[j - 1];
                }
                else if (j == 0 && chj != chi)
                {
                    lps[i] = 0;//j
                    i++;
                }
            }

            return lps;
        }
}
