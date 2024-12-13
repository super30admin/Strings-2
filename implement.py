# The strStr method finds the first occurrence of `needle` in `haystack`.

# Check if `haystack` is shorter than `needle`; return -1 if true.
# Iterate through `haystack` and compare substrings of length equal to `needle`.
# If a match is found, return the starting index.
# Return -1 if `needle` is not found.

# TC: O(n * m) - n is the length of `haystack`, m is the length of `needle`.
# SC: O(1) - Constant space usage.


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:

        if len(haystack) < len(needle):
            return -1

        for i in range(len(haystack)):
            if haystack[i:i+len(needle)] == needle:
                return i

        return -1 