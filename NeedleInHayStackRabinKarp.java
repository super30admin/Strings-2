// TC: O(n)
// SC: O(1)

import java.math.BigInteger;

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;

        BigInteger base = BigInteger.valueOf(26);
        BigInteger multiple = base.pow(needle.length() - 1);

        BigInteger lookupSum = BigInteger.valueOf(0);
        for (int i = 0; i < needle.length(); i++) {
            lookupSum = (lookupSum.multiply(base)).add(BigInteger.valueOf(needle.charAt(i) - 'a'));
        }

        BigInteger runningHash = BigInteger.valueOf(0);
        for (int i = 0; i < haystack.length(); i++) {
            // incoming
            runningHash = (runningHash.multiply(base))
                    .add(BigInteger.valueOf(haystack.charAt(i) - 'a'));

            // outgoing
            if (i >= needle.length()) {
                char outChar = haystack.charAt(i - needle.length());
                BigInteger temp = BigInteger.valueOf(outChar - 'a').multiply(multiple);
                runningHash = runningHash.subtract(temp);
            }
            // compare running hash with lookupSum
            if (runningHash.equals(lookupSum)) {
                return i - needle.length() + 1;
            }

        }
        return -1;
    }

}