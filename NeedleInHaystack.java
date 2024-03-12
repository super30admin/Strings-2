// Time: O(n) n = length of haystack
// Space: O(1)

// Approach: Rolling hash to keep track of leaving and entering elements.
// when the hashes match; return index

import java.math.BigInteger;

public class NeedleInHaystack {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }

        BigInteger needleHash = BigInteger.ZERO;
        BigInteger twentySix = BigInteger.valueOf(26);
        int n = needle.length();

        for (int i = 0; i < n; i++) {
            char current = needle.charAt(i);
            needleHash = needleHash.multiply(twentySix).add(BigInteger.valueOf(current - 'a' + 1));
        }

        BigInteger currentHash = BigInteger.ZERO;

        for (int i = 0; i < haystack.length(); i++) {
            char current = haystack.charAt(i);
            // outgoing
            if (i >= n) {
                currentHash = currentHash.mod(twentySix.pow(n - 1));
            }

            // incoming
            currentHash = currentHash.multiply(twentySix).add(BigInteger.valueOf(current - 'a' + 1));

            if (currentHash.equals(needleHash)) {
                return i - n + 1;
            }
        }

        return -1;
    }

}
