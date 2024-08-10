// Time Complexity: O(m + n)
// Space Complexity: O(m + n)

import java.math.BigInteger;

class Solution {
    public int strStr(String haystack, String needle) {

        int n = needle.length();

        if (n > haystack.length())
            return -1;
        BigInteger hash1 = BigInteger.ZERO;
        BigInteger k = BigInteger.valueOf(26);

        for (int i = 0; i < n; i++) {
            char c = needle.charAt(i);
            hash1 = (hash1.multiply(k)).add(BigInteger.valueOf(c - 'a' + 1));
        }

        BigInteger hash2 = BigInteger.ZERO;

        for (int i = 0; i < haystack.length(); i++) {
            if (i - n >= 0) {
                char out = haystack.charAt(i - n);
                hash2 = hash2.mod(k.pow(n - 1));
            }

            char in = haystack.charAt(i);
            hash2 = (hash2.multiply(k)).add(BigInteger.valueOf(in - 'a' + 1));
            if (hash2.equals(hash1))
                return i - n + 1;
        }

        return -1;
    }

}