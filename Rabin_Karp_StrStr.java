/*
Approach: we use rabin karp algorithm. if two strings are the same, 
they must have the same hash value.
We use rolling hash function as rabin fingerprint.
 */

/*
Time: O(m+n) on average, in worst case O(mn) if many collisions
Space: O(1) constant
 */

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        if (n == 0) return 0;
        if (m < n) return -1;

        long base = 26;
        long mod = 1000000007;

        long needleHash = 0;
        long windowHash = 0;
        long power = 1; // base^(n-1)

        // compute base^(n-1)
        for (int i = 0; i < n - 1; i++) {
            power = (power * base) % mod;
        }

        // initial hash of needle and first window
        for (int i = 0; i < n; i++) {
            needleHash = (needleHash * base + (needle.charAt(i) - 'a' + 1)) % mod;
            windowHash = (windowHash * base + (haystack.charAt(i) - 'a' + 1)) % mod;
        }

        // slide window
        for (int i = 0; i <= m - n; i++) {

            // check hash match
            if (needleHash == windowHash) {
                // verify to avoid collision
                if (haystack.substring(i, i + n).equals(needle)) {
                    return i;
                }
            }

            // move window
            if (i < m - n) {
                // remove left char
                windowHash = (windowHash - (haystack.charAt(i) - 'a' + 1) * power % mod + mod) % mod;

                // add right char
                windowHash = (windowHash * base + (haystack.charAt(i + n) - 'a' + 1)) % mod;
            }
        }

        return -1;
    }
}