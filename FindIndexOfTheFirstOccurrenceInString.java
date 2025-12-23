/*
 * FindIndexOfTheFirstOccurrenceInString
 *
 * Algorithm approach:
 * - Naive substring search: for each possible starting index in `haystack`, compare
 *   characters of `needle` one by one until a mismatch or full match is found.
 *
 * Time complexity: O(M * N) in the worst case where M = haystack.length() and
 *   N = needle.length(). For each start position (up to M - N + 1) we may compare
 *   up to N characters.
 * Space complexity: O(1) extra space.
 *
 * LeetCode: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/ (28)
 */

public class FindIndexOfTheFirstOccurrenceInString {

    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (n > m) return -1;
        int i = 0;
        while (i <= m - n) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 0; // needle pointer
                int k = i;
                while (haystack.charAt(k) == needle.charAt(j)) {
                    k++;
                    j++;
                    if (j == n) return i;
                }
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FindIndexOfTheFirstOccurrenceInString().strStr("sadbutsad", "but"));
    }
}
