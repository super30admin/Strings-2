# The findAnagrams method finds all start indices of `p`'s anagrams in `s`.

# Check if `s` is shorter than `p`; return an empty list if true.
# Use frequency arrays (pmap and smap) to count characters in `p` and in sliding windows of `s`.
# Compare frequency arrays to detect anagrams.

# Initialize pmap with character counts of `p`.
# Populate smap for the first window and compare with pmap.

# Slide the window through `s`, updating smap by adding the new character and removing the old.
# If smap matches pmap, append the starting index of the window to the result.

# TC: O(n) - Linear scan of `s` with constant-time frequency comparisons.
# SC: O(1) - Fixed-size arrays for character counts.


from typing import List


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(s) < len(p):
            return []

        pmap = [0] * 26
        smap = [0] * 26
        result = []

        for char in p:
            pmap[ord(char) - ord('a')] += 1

        for i in range(len(p)):
            smap[ord(s[i]) - ord('a')] += 1

        if smap == pmap:
            result.append(0)

        for i in range(len(p), len(s)):
            smap[ord(s[i]) - ord('a')] += 1
            smap[ord(s[i - len(p)]) - ord('a')] -= 1

            if smap == pmap:
                result.append(i - len(p) + 1)

        return result