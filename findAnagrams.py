from typing import List

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        """
        Approach:
        1. Create frequency arrays (size 26 for lowercase letters) for both `p` and a sliding window in `s`.
        2. Slide a window over `s` of size equal to `p`, updating character counts dynamically.
        3. Whenever the window's frequency matches `p`'s frequency, record the start index.

        Time Complexity: O(n), where n = len(s) — we traverse `s` once and compare two arrays of fixed size.
        Space Complexity: O(1), since the size of both frequency arrays is constant (26 characters).
        """

        if len(p) > len(s):
            return []

        res = []
        p_count = [0] * 26
        s_count = [0] * 26
        a = ord('a')

        for char in p:
            p_count[ord(char) - a] += 1

        for i in range(len(s)):
            s_count[ord(s[i]) - a] += 1

            if i >= len(p):
                s_count[ord(s[i - len(p)]) - a] -= 1

            if s_count == p_count:
                res.append(i - len(p) + 1)

        return res
