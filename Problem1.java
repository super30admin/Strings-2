import java.math.BigInteger;


// Time Complexity : O(m*n) where m and n are the lengths of haystack and needle
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using 2 pointers, check if the needle exists in haystack starting from every index. Return the starting index of the first match.
 */
class WindowSolution {
    public int strStr(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();

        for (int windowStart = 0; windowStart <= n - m; windowStart++) {
            for (int i = 0; i < m; i++) {
                if (needle.charAt(i) != haystack.charAt(windowStart + i)) {
                    break;
                }

                // didn't break so we found the match
                if (i == m - 1) {
                    return windowStart;
                }
            }
        }

        return -1;
    }
}

// Time Complexity : O(m+n) where m and n are the lengths of haystack and needle
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * Use a hash function where the element and its position generates unique hash value using the power of 26 since there are only 26 unique chars.
 * Create the hash of the needle.
 * Iteratively calculate a rolling hash from haystack substring where there are same number of charatacter from needle. When the hash matches, return the result
 */
class HashingSolution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        if (n > m) {
            return -1;
        }

        // Using BigInteger to not run out of range for longer needle strings
        BigInteger zero = BigInteger.valueOf(0);
        BigInteger base = BigInteger.valueOf(26);
        BigInteger needleHash = zero;
        for (int i = 0; i < n; i++) {
            needleHash = needleHash.multiply(base).add(BigInteger.valueOf(needle.charAt(i) - 'a' + 1));
        }

        BigInteger haystackHash = zero;
        BigInteger outgoingHash = base.pow(n);
        for (int i = 0; i < m; i++) {
            // include the next character in hash
            haystackHash = haystackHash.multiply(base).add(BigInteger.valueOf(haystack.charAt(i) - 'a' + 1));

            // remove the first character since we only require n chars for hashing function
            if (i >= n) {
                haystackHash = haystackHash.subtract(outgoingHash.multiply(BigInteger.valueOf(haystack.charAt(i - n) - 'a' + 1)));
            }

            if (needleHash.equals(haystackHash))
                return i - n + 1;
        }

        return -1;
    }
}