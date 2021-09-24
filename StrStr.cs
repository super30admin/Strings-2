using System;
using System.Collections.Generic;
using System.Text;

namespace Strings
{
    class StrStrNeedle
    {
        //BruteForce
        //TC: O(mn)
        //SC: O(1)
        public int StrStr(string hayStack, string needle)
        {
            if (needle == null || needle.Length == 0)
            {
                return 0;
            }
            int m = hayStack.Length;
            int n = needle.Length;
            for (int i = 0; i < m-n+1 ; i++) // i < hayStack.Length
            {
                if (hayStack[i] == needle[0])
                {
                    int k = i;
                    int j = 0;
                    while (j < n && k < m)
                    {
                        if (hayStack[k] == needle[j])
                        {
                            k++;
                            j++;
                        }
                        else
                        {
                            break;
                        }
                    }
                    if (j == n)
                    {
                        return k - n;
                    }
                }
            }
            return -1;
        }

        //KMP Algorithm
        //TC: O(m+n)
        //SC: O(n)
        public int KMPStrStr(string hayStack, string needle)
        {
            if (needle == null || needle.Length == 0)
            {
                return 0;
            }
            int m = hayStack.Length;
            int n = needle.Length;
            int i = 0, j = 0;
            int[] lps = KMPlps(needle);
            while (i < m)
            {
                if (hayStack[i] == needle[j])
                {
                    i++;
                    j++;
                    if (j == n) return i - n;
                }
                else if (hayStack[i] != needle[j] && j > 0)
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

        private int[] KMPlps(string needle)
        {
            int[] lps = new int[needle.Length];
            int i = 1;
            int j = 0;
            while (i < needle.Length)
            {
                if (needle[i] == needle[j])
                {
                    j++;
                    lps[i] = j;
                    i++;
                }
                else if (needle[i] != needle[j] && j > 0)
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
}
