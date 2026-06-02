// Time Complexity : O(m + n) where m is length of haystack and n is length of needle
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use the Rabin-Karp rolling hash technique to compare substring hashes instead of matching characters repeatedly.
// First, we compute the hash of the needle and then maintain a rolling hash for the current window in haystack.
// As the window slides, we add the incoming character and remove the outgoing character to update the hash efficiently.

class Solution {

    public int strStr(
        String haystack,
        String needle
    ) {

        int m = haystack.length();

        int n = needle.length();

        // hash of pattern
        long pHash = 0;

        // compute pattern hash
        for (int i = 0; i < n; i++) {

            char c = needle.charAt(i);

            pHash =
                (
                    pHash * 26
                    +
                    (c - 'a' + 1)
                );
        }

        // rolling hash of current window
        long currHash = 0;

        // positional factor for removing outgoing char
        long posFac =
            (long)Math.pow(26, n);

        for (int i = 0; i < m; i++) {

            char in =
                haystack.charAt(i);

            // add incoming character
            currHash =
                (
                    currHash * 26
                    +
                    (in - 'a' + 1)
                );

            // remove outgoing character
            if (i >= n) {

                char out =
                    haystack.charAt(i - n);

                currHash =
                    currHash
                    -
                    (
                        posFac
                        *
                        (out - 'a' + 1)
                    );
            }

            // hash match found
            if (currHash == pHash) {

                return i - n + 1;
            }
        }

        return -1;
    }
}