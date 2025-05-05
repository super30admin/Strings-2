class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        """
        Approach:
        1. Use a sliding window of size equal to the length of `needle` to iterate over `haystack`.
        2. At each index, compare the substring `haystack[i:i+length]` with `needle`.
        3. If a match is found, return the starting index; if not found after iteration, return -1.

        Time Complexity: O((n - m + 1) * m), where n = len(haystack), m = len(needle)
        Space Complexity: O(1), as no extra space is used (slicing creates temporary strings but not stored)
        """

        length = len(needle)
        i = 0
        while i < len(haystack):
            if (i + length) <= len(haystack) and needle == haystack[i:i + length]:
                return i
            i += 1
        return -1
