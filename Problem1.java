import java.math.BigInteger;

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * This is the Rolling Hash Algorithm. We first take the hash value of the
 * needle(source string). Then we construct a window of size len(needle) and keep getting
 * that window string's hash value and keep comparing it with the hash(needle).
 * Whenever we find the equal hashes, we return the start of that window
 *
 */


public class Problem1 {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        if(n > m) return -1;

        BigInteger hash = BigInteger.ZERO;
        BigInteger k = BigInteger.valueOf(26);

        for(int i=0; i<n; i++) {
            char c = needle.charAt(i);
            hash = hash.multiply(k).add(BigInteger.valueOf(c - 'a' + 1));
        }


        BigInteger hash2 = BigInteger.ZERO;

        for(int i=0; i<m; i++) {
            char c = haystack.charAt(i);

            //outgoing
            if(i >= n) {
                hash2 = hash2.mod(k.pow(n-1));
            }

            hash2 = hash2.multiply(k).add(BigInteger.valueOf(c - 'a' + 1));
            if(hash.equals(hash2)) return i-n+1;
        }

        return -1;

    }
}
