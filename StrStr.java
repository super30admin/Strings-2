import java.math.BigInteger;

/**
 * Leetcode 28. Find the Index of the First Occurrence in a String
 * Link: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 */
//------------------------------------ Solution 1 -----------------------------------
public class StrStr {
    /**
     * At each index of haystack string try to match if a string starting from that index will match with
     * needle string or not. If there is match move both pointers. In between if there is a mismatch reset the pointer
     * on haystack to next element where it previously started.
     *
     * TC: O(mn) m - needle length n - haystack length
     * SC: O(1)
     */
    public int strStr(String haystack, String needle) {
        int j = 0;
        int n = haystack.length();
        int m = needle.length();
        for (int i = 0; i <= n - m; i++) {
            int k = i;
            while (haystack.charAt(k) == needle.charAt(j)) {
                j++;
                k++;

                if (j == m) {
                    return i;
                }
            }

            j = 0;
        }
        return -1;
    }
}

//------------------------------------ Solution 2 -----------------------------------
class StrStr2 {
    /**
     * Robin Karp rolling hash solution
     * Limitation is that it works for smaller string/haystack and small pattern(here 26 lower case alphabets) as it will
     * lead to overflow of even BigInteger
     *
     * TC: O(m + n)
     * SC: O(1)
     */
    public int strStr(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();
        if (m > n) {
            return -1;
        }
        BigInteger hashNiddle = BigInteger.ZERO;
        BigInteger hashHay = BigInteger.ZERO;
        BigInteger k = BigInteger.valueOf(26);

        for (char c: needle.toCharArray()) {
            hashNiddle = hashNiddle.multiply(k).add(BigInteger.valueOf(c - 'a' + 1));
        }

        for (int i = 0; i < n; i++) {
            if (i >= m) {
                hashHay = hashHay.mod(k.pow(m - 1));
            }

            hashHay = hashHay.multiply(k).add(BigInteger.valueOf(haystack.charAt(i) - 'a' + 1));

            if (hashNiddle.equals(hashHay)) {
                return i - m + 1;
            }
        }
        return -1;
    }
}

//------------------------------------ Solution 3 -----------------------------------
class StrStr3 {
    /**
     * KMP algorithm solution where we find prepare the longest prefix suffix array on given pattern (leave at-least one
     * char while finding longest as we need use this to not move back i pointer on longer haystack string). prefix is in
     * pattern and suffix is in longer string, j resets to previous index's lps(efficient shrink) and lps building while
     * we have match and move to bigger string in pattern also expands the window by j++ and i++ hence efficient expansion.
     * Hence finding lps on small pattern is O(m) TC and we are never moving back i pointer on the longer string so TC from
     * longer string is O(n)
     *
     * TC: O(m + n)
     * SC: O(m) for lps array of length for small pattern/needle string
     */
    public int strStr(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();
        if (m > n) {
            return -1;
        }

        //build longest prefix suffix array for the needle string
        int[] lps = buildLongestPrefixSuffix(needle);

        int j = 0;
        int i = 0;
        while (i < n) { //while not all chars from haystack processed
            if (haystack.charAt(i) == needle.charAt(j)) { //if chars in both strings at given pointer match expand window
                i++;
                j++;

                if (j == m) { // if all chars in needle are processed, return first occurrence
                    return i - j;
                }
            } else if (haystack.charAt(i) != needle.charAt(j) && j > 0) { //take j back till prefix in needle and suffix in haystack match
                j = lps[j - 1];
            } else { //this is (haystack.charAt(i) != needle.charAt(j) && j == 0) // no match, explore new char from haystack for matching
                i++;
            }
        }

        return -1; // no match found
    }

    private int[] buildLongestPrefixSuffix(String pattern) {
        int[] lps = new int[pattern.length()];
        lps[0] = 0;
        int j = 0;
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(j) == pattern.charAt(i)) {
                j++;
                lps[i] = j;
                i++;
            } else if (pattern.charAt(j) != pattern.charAt(i) && j > 0) {
                j = lps[j - 1];
            } else { // this is (pattern.charAt(j) != pattern.charAt(i) && j == 0)
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
}