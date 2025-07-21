# ----------------------------------------------------
# Intuition:
#
# 1. Optimized Sliding Window with Fixed Array:
#    - Use fixed-size arrays (length 26) to track character frequencies.
#    - Slide over s updating the window counts and compare with p's counts.
#    - Time: O(n), Space: O(1)
#
# 2. Sliding Window with HashMap (Counter):
#    - Use Counter (hashmap) for frequency counts in p and current window.
#    - Slide window and compare counts each step.
#    - Time: O(n * 26) ≈ O(n), Space: O(26)
#
# 3. Naive Brute Force:
#    - Check every substring by sorting and comparing with sorted p.
#    - Time: O((n-m+1)*m log m), Space: O(m)
# ----------------------------------------------------

from typing import List
from collections import Counter

class Solution:

    # ----------------------------------------------------
    # 1. Optimized Sliding Window with Fixed Array
    # Time: O(n), Space: O(1)
    # ----------------------------------------------------
    def findAnagrams(self, s: str, p: str) -> List[int]:
        res = []
        m, n = len(p), len(s)
        if m > n:
            return res

        # Frequency array for p and current window in s
        p_count = [0] * 26
        s_count = [0] * 26

        # Build frequency array for p
        for ch in p:
            p_count[ord(ch) - ord('a')] += 1

        for i in range(n):
            # Add current char to the window frequency
            s_count[ord(s[i]) - ord('a')] += 1

            # Remove char left of window if window size exceeded p's length
            if i >= m:
                left_char = s[i - m]
                s_count[ord(left_char) - ord('a')] -= 1

            # If window frequency matches p's, record start index
            if s_count == p_count:
                res.append(i - m + 1)

        return res

    # ----------------------------------------------------
    # 2. Sliding Window with HashMap / Counter
    # Time: O(n * 26) ≈ O(n), Space: O(26)
    # ----------------------------------------------------
    def findAnagrams_hashmap(self, s: str, p: str) -> List[int]:
        res = []
        m, n = len(p), len(s)
        if m > n:
            return res

        # Counter for p and sliding window in s
        p_count = {}
        for ch in p:
            p_count[ch] = p_count.get(ch, 0) + 1
        window_count = {}

        for i in range(n):
            # Add current char to window counter
            window_count[s[i]] = window_count.get(s[i], 0) + 1

            # Remove left char if window size exceeded p's length
            if i >= m:
                left_ch = s[i - m]
                if window_count[left_ch] == 1:
                    del window_count[left_ch]
                else:
                    window_count[left_ch] -= 1

            # If window matches p's count, record start index
            if window_count == p_count:
                res.append(i - m + 1)

        return res

    # ----------------------------------------------------
    # 3. Naive Brute Force
    # Time: O((n-m+1)*m log m), Space: O(m)
    # ----------------------------------------------------
    def findAnagrams_bruteforce(self, s: str, p: str) -> List[int]:
        res = []
        m, n = len(p), len(s)
        # Precompute sorted p for easy comparison
        p_sorted = ''.join(sorted(p))

        for i in range(n - m + 1):
            # Sort current substring and compare with sorted p
            if ''.join(sorted(s[i:i+m])) == p_sorted:
                res.append(i)

        return res


# ----------------------------------------------------
# Example Usage and Test Cases:
# ----------------------------------------------------

if __name__ == "__main__":
    sol = Solution()

    print("Optimized Fixed Array Sliding Window:")
    print(sol.findAnagrams("cbaebabacd", "abc"))  # [0, 6]
    print(sol.findAnagrams("abab", "ab"))         # [0, 1, 2]

    print("\nSliding Window with HashMap / Counter:")
    print(sol.findAnagrams_hashmap("cbaebabacd", "abc"))  # [0, 6]
    print(sol.findAnagrams_hashmap("abab", "ab"))         # [0, 1, 2]

    print("\nNaive Brute Force:")
    print(sol.findAnagrams_bruteforce("cbaebabacd", "abc"))  # [0, 6]
    print(sol.findAnagrams_bruteforce("abab", "ab"))         # [0, 1, 2]
