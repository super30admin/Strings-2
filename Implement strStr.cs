//Robin Karp algorithm
/*
  Time complexity: O(n+m)
  Space complexity: O(1)
  
*/


public class Solution {
    public int StrStr(string haystack, string needle) {
        BigInteger hash1 = BigInteger.Zero;
        BigInteger hash2 = BigInteger.Zero;

        int m = needle.Length;
        int n = haystack.Length;

        if(n<m) return -1;

        for(int i=0; i<needle.Length; i++)
        {
            hash1 = (hash1 * 26 + (needle[i] - 'a' + 1));
        }

        for(int i = 0; i<haystack.Length;i++)
        {
            if(i>=m)
            {
                hash2 = hash2%(BigInteger.Pow(26,m-1));
            }

            hash2 = (hash2 * 26 + (haystack[i] - 'a' + 1));

            if(hash1.Equals(hash2))
                return i-m+1;
        }

        return -1;
    }
}
