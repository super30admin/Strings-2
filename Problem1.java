import java.math.BigInteger;

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (n > m) {
            return -1;
        }

        BigInteger base = BigInteger.valueOf(26);
        BigInteger mod = BigInteger.valueOf((long)Math.pow(2, 32));  // Use a large prime for mod

        BigInteger hash = BigInteger.ZERO;
        BigInteger nhash = BigInteger.ZERO;
        BigInteger kl = base.modPow(BigInteger.valueOf(n - 1), mod); 

        for (int i = 0; i < n; i++) {
            char in = needle.charAt(i);
            hash = (hash.multiply(base).add(BigInteger.valueOf(in - 'a' + 1))).mod(mod);
            char inH = haystack.charAt(i);
            nhash = (nhash.multiply(base).add(BigInteger.valueOf(inH - 'a' + 1))).mod(mod);
        }

        for (int i = 0; i <= m - n; i++) {
            if (nhash.equals(hash)) {
                if (haystack.substring(i, i + n).equals(needle)) {
                    return i;
                }
            }
            if (i < m - n) {
                char out = haystack.charAt(i);
                char in = haystack.charAt(i + n);
                nhash = (nhash.subtract(BigInteger.valueOf(out - 'a' + 1).multiply(kl)).multiply(base).add(BigInteger.valueOf(in - 'a' + 1))).mod(mod);
            }
        }

        return -1;
    }
}

