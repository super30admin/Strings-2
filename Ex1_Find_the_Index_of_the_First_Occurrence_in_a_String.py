    # ----------------------------------------------------
    # Intuition:
    #
    # 1. KMP (Knuth-Morris-Pratt) Algorithm:
    #    - Preprocess the needle to create an LPS (Longest Prefix Suffix) array.
    #      This helps skip comparisons when a mismatch happens.
    #    - While scanning haystack, use LPS to avoid re-checking characters,
    #      thus achieving efficient pattern searching.
    #    - Time Complexity Explanation:
    #      * Building LPS takes O(m) time where m = len(needle).
    #      * Searching haystack takes O(n) time where n = len(haystack).
    #      * Total O(n + m) since each character is processed at most twice.
    #    - Space Complexity Explanation:
    #      * LPS array stores at most m integers.
    #      * So space is O(m).
    #
    # 2. Rabin-Karp Algorithm (Rolling Hash):
    #    - Calculate rolling hash for needle and for each window in haystack.
    #    - On hash match, verify substring equality to avoid false positives.
    #    - Time Complexity Explanation:
    #      * Average case is O(n + m), assuming few hash collisions.
    #      * Worst case is O(n*m), when many collisions cause substring checks.
    #    - Space Complexity Explanation:
    #      * Uses constant extra space for hash values and base powers.
    #      * So space is O(1).
    #
    # 3. Naive Approach:
    #    - Check every substring of haystack (length = m) against needle.
    #    - Time Complexity Explanation:
    #      * For each of the n-m+1 positions, we compare up to m characters.
    #      * Total O(n*m).
    #    - Space Complexity Explanation:
    #      * Only a few variables used, no extra storage.
    #      * O(1) space.
    # ----------------------------------------------------

    # ----------------------------------------------------
    # 1. KMP Algorithm (Optimized)
    # Time: O(n + m) because each character in haystack and needle is scanned at most twice.
    # Space: O(m) for the LPS array.
    # ----------------------------------------------------

from typing import List

class Solution:

    def strStr(self, haystack: str, needle: str) -> int:
        n, m = len(haystack), len(needle)
        if m == 0:
            return 0
        if m > n:
            return -1

        # Build LPS array for needle in O(m) time and O(m) space
        lps = self.build_lps(needle)

        i = 0  # pointer for haystack
        j = 0  # pointer for needle

        while i < n:
            if haystack[i] == needle[j]:
                i += 1
                j += 1
                if j == m:
                    # Found full match of needle in haystack
                    return i - j
            else:
                if j != 0:
                    # Use LPS to avoid re-checking characters in needle
                    j = lps[j - 1]
                else:
                    # Move haystack pointer forward if no prefix to fallback
                    i += 1
        return -1

    def build_lps(self, pattern: str) -> List[int]:
        m = len(pattern)
        lps = [0] * m
        length = 0  # length of the previous longest prefix suffix
        i = 1
        while i < m:
            if pattern[i] == pattern[length]:
                length += 1
                lps[i] = length
                i += 1
            else:
                if length != 0:
                    length = lps[length - 1]
                else:
                    lps[i] = 0
                    i += 1
        return lps

    # ----------------------------------------------------
    # 2. Rabin-Karp Algorithm (Rolling Hash)
    # Time: Avg O(n + m) assuming rare collisions, Worst O(n*m) if many collisions
    # Space: O(1) for rolling hash variables
    # ----------------------------------------------------
    # def strStr(self, haystack: str, needle: str) -> int:
    #     n, m = len(haystack), len(needle)
    #     if m == 0:
    #         return 0
    #     if m > n:
    #         return -1
    #
    #     base = 256
    #     mod = 10**9 + 7
    #
    #     needle_hash = 0
    #     window_hash = 0
    #     highest_base = 1
    #
    #     # Compute initial hash for needle and first window of haystack
    #     for i in range(m):
    #         needle_hash = (needle_hash * base + ord(needle[i])) % mod
    #         window_hash = (window_hash * base + ord(haystack[i])) % mod
    #         if i > 0:
    #             highest_base = (highest_base * base) % mod
    #
    #     # Slide over haystack
    #     for i in range(n - m + 1):
    #         if needle_hash == window_hash:
    #             # Hashes match; verify substring to avoid collisions
    #             if haystack[i:i+m] == needle:
    #                 return i
    #         if i < n - m:
    #             # Roll the hash: remove left char and add right char
    #             window_hash = (window_hash - ord(haystack[i]) * highest_base) % mod
    #             window_hash = (window_hash * base + ord(haystack[i + m])) % mod
    #             window_hash = (window_hash + mod) % mod  # ensure positive
    #
    #     return -1

    # ----------------------------------------------------
    # 3. Naive Approach
    # Time: O(n*m) because we check every substring and compare all characters
    # Space: O(1) only uses fixed variables
    # ----------------------------------------------------
    # def strStr(self, haystack: str, needle: str) -> int:
    #     n, m = len(haystack), len(needle)
    #     if m == 0:
    #         return 0
    #     for i in range(n - m + 1):
    #         j = 0
    #         while j < m and haystack[i + j] == needle[j]:
    #             j += 1
    #         if j == m:
    #             return i
    #     return -1


# ----------------------------------------------------
# Example usage:
# ----------------------------------------------------

if __name__ == "__main__":
    sol = Solution()

    print(sol.strStr("sadbutsad", "sad"))    # Output: 0
    print(sol.strStr("leetcode", "leeto"))   # Output: -1
    print(sol.strStr("hello", ""))            # Output: 0
    print(sol.strStr("abcxabcdabxabcdabcdabcy", "abcdabcy"))  # Output: 15
