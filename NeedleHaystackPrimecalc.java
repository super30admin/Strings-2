
// Time Complexity : O(N*M) where N is the length of the input string s and M is the length of the pattern p.
// Space Complexity : O(1) as we are using constant space.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach
// We can use a sliding window approach to find all anagrams of p in s. 
// We maintain a frequency map of characters in p and keep track of how many characters have been matched in the current window. 
// As we expand the window, we update the frequency map and check if we have a valid anagram. If the window size exceeds the length of p, we shrink the window from the left and update the frequency map accordingly. 
// Finally, we return the list of starting indices of valid anagrams found in s.
// We can also use a binary search approach by sorting the characters of p and comparing it with the sorted characters of each window in s. However, this approach would have a higher time complexity of O(N*M log M) due to the sorting

import java.math.BigInteger;

class Solution {
    public int strStr(String haystack, String needle) {

        int m = haystack.length();
        int n = needle.length();

        if (n == 0) return 0;
        if (n > m) return -1;

        BigInteger needleHash = BigInteger.ZERO;

        BigInteger base = BigInteger.valueOf(26);
        BigInteger posFac = base.pow(n);

        // Compute needle hash
        for (int i = 0; i < n; i++) {

            char c = needle.charAt(i);

            needleHash = needleHash.multiply(base)
                    .add(BigInteger.valueOf(c - 'a' + 1));
        }

        BigInteger hayHash = BigInteger.ZERO;

        for (int i = 0; i < m; i++) {

            char incoming = haystack.charAt(i);

            hayHash = hayHash.multiply(base)
                    .add(BigInteger.valueOf(incoming - 'a' + 1));

            // Remove outgoing char
            if (i >= n) {

                char outgoing = haystack.charAt(i - n);

                hayHash = hayHash.subtract(
                        posFac.multiply(
                                BigInteger.valueOf(outgoing - 'a' + 1)
                        )
                );
            }

            // Compare hashes
            if (i >= n - 1 && hayHash.equals(needleHash)) {
                return i - n + 1;
            }
        }

        return -1;
    }
}