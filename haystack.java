import java.math.BigInteger;

class Solution {
    /**
     * Time Complexity: O(n), where n is the length of the haystack string.
     * Space Complexity: O(m), where m is the length of the needle string.
     */
    public int strStr(String haystack, String needle) {
        // Edge case: If needle is an empty string, return 0
        if (needle.length() == 0) return 0;

        // Edge case: If haystack is shorter than needle, return -1
        if (haystack.length() < needle.length()) return -1;

        // Calculate the hash of the needle
        BigInteger needleHash = BigInteger.ZERO;
        BigInteger base = BigInteger.valueOf(26); // Base for the hash function
        for (int i = 0; i < needle.length(); i++) {
            needleHash = needleHash.multiply(base).add(BigInteger.valueOf(needle.charAt(i) - 'a' + 1));
        }

        // Initialize variables for the rolling hash of haystack
        BigInteger hayStackHash = BigInteger.ZERO;
        BigInteger pow = base.pow(needle.length() - 1); // Base raised to the power of (needle length - 1)
        int left = 0; // Left pointer of the sliding window

        // Iterate through the haystack with the right pointer
        for (int right = 0; right < haystack.length(); right++) {
            // Remove the leftmost character from the hash if the window size exceeds the needle length
            if (right - left >= needle.length()) {
                char leftChar = haystack.charAt(left);
                BigInteger leftValue = BigInteger.valueOf(leftChar - 'a' + 1);
                hayStackHash = hayStackHash.subtract(leftValue.multiply(pow));
                left++; // Move the left pointer
            }

            // Add the current character to the hash
            char rightChar = haystack.charAt(right);
            hayStackHash = hayStackHash.multiply(base).add(BigInteger.valueOf(rightChar - 'a' + 1));

            // Compare the hash of the current window with the hash of the needle
            if (hayStackHash.equals(needleHash)) {
                return left; // Return the starting index of the found substring
            }
        }

        // If no match is found, return -1
        return -1;
    }
}
