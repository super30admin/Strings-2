/*
 * FindIndexOfTheFirstOccurrenceInStringRollingHash
 *
 * Algorithm approach:
 * - Rolling-hash (Rabin-Karp style) substring search. Compute a numeric hash for
 *   the `needle` and a rolling hash for the current window in `haystack`. Compare
 *   hashes to detect potential matches and return the index when hashes are equal.
 *   (Note: this simple implementation does not use a modulus for overflow control
 *   or to reduce collisions — it's a teaching/example implementation.)
 *
 * Time complexity: Average O(M + N) for computing rolling hashes, but worst-case
 *   O(M * N) if many hash collisions occur and each candidate is rechecked.
 * Space complexity: O(1) extra space.
 *
 * LeetCode: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/ (28)
 */

public class FindIndexOfTheFirstOccurrenceInStringRollingHash {

    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        long kl = (long)Math.pow(26, n - 1);
        //calculate hash of needle
        long pHash = 0;

        for (int i = 0; i < n; i++) {
            char ch = needle.charAt(i);
            pHash = pHash * 26 + ch - 'a' + 1;
        }

        System.out.println(pHash);
        long sHash = 0;
        for (int i = 0; i < m; i++) {
            char ch = haystack.charAt(i);
            //Incoming char
            sHash = sHash * 26 + ch - 'a' + 1;
            if (i >= n - 1) {
                if (pHash == sHash) return i - n + 1;
                //Outgoing char
                sHash = sHash - (kl * (haystack.charAt(i - n + 1) - 'a' + 1));
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(
                new FindIndexOfTheFirstOccurrenceInStringRollingHash().strStr("sadbutsad", "but"));
    }

}
