/*
 * FindIndexOfTheFirstOccurrenceInStringKMP
 *
 * Algorithm approach:
 * - Knuth-Morris-Pratt (KMP) string-search algorithm. Precompute the LPS
 *   (longest proper prefix which is also suffix) array for the `needle` and
 *   then scan the `haystack` advancing indices with help of LPS to avoid
 *   re-checking characters on mismatch.
 *
 * Time complexity: O(M + N) where M = haystack.length() and N = needle.length().
 * Space complexity: O(N) for the LPS array.
 *
 * LeetCode: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/ (28)
 */

import java.util.Arrays;

public class FindIndexOfTheFirstOccurrenceInStringKMP {

    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (n == 0) return 0; // per problem definition
        if (n > m) return -1;

        int[] lps = getLPSArray(needle, n);
        int i = 0; // index for haystack
        int j = 0; // index for needle
        while (i < m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == n) return i - j;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    private int[] getLPSArray(String needle, int n) {
        int[] lps = new int[n];
        int len = 0; // length of the previous longest prefix suffix
        int i = 1;
        while (i < n) {
            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        System.out.println(new FindIndexOfTheFirstOccurrenceInStringKMP().strStr("mississippi", "issip"));
    }
}
