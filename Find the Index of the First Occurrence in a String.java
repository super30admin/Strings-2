/*
Time Complexity (TC)
Precompute nValue (needle hash): O(n)
Precompute initial hayValue: O(n)
Sliding window loop over m - n + 1 windows:
Space Complexity (SC): O(1)

Approach:
Step 1: Compute Hashes
Compute hash of needle (nValue).
Compute initial hash of first n characters in haystack (hayValue).

Step 2: Rolling Hash Sliding Window
Slide over haystack from i = 0 to i = m - n.
At each position:
If hayValue == nValue, return i as the match position.
If not at the end, update hayValue by:
Removing the contribution of the first character in the current window.
Shifting the hash left by multiplying with base.
Adding the next character at the end of the window.

Step 3: Return -1 if No Match
If no matching hash found after sliding through haystack, return -1 indicating needle is not present.
  */



import java.math.BigInteger;
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(n > m) return -1;
        int base = 26; // since we use 26 letters
        BigInteger nValue = BigInteger.ZERO;
        BigInteger hayValue = BigInteger.ZERO;
        BigInteger highOrder = BigInteger.valueOf(base).pow(n - 1);
        for(int i=0;i<n;++i){
            int ch = needle.charAt(i);
            nValue = nValue.multiply(BigInteger.valueOf(base))
            .add(BigInteger.valueOf(ch - 'a' + 1));
        }
        for(int i=0; i<n;++i){
            int ch = haystack.charAt(i);
            hayValue = hayValue.multiply(BigInteger.valueOf(base))
            .add(BigInteger.valueOf(ch - 'a' +1));
        }

        for(int i=0 ; i<= m-n ; ++i){
            if(hayValue.equals(nValue) )
                return i;
            if(i+ n < m){
                // Remove first char of the current window
                hayValue = hayValue.subtract(
                    BigInteger.valueOf(haystack.charAt(i) - 'a' + 1)
                                .multiply(highOrder)
                );
                // Multiply to shift left
                hayValue = hayValue.multiply(BigInteger.valueOf(base));
                // Add the next character at the end of the window
                hayValue = hayValue.add(
                        BigInteger.valueOf(haystack.charAt(i + n) - 'a' + 1)
                );
            }
        }
        return -1;
    }
}
