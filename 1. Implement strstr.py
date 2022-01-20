class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        # Time Complexity = O(n*m)
        # Space Complexity = O(1)
        if needle == "":
            return 0

        for i in range(len(haystack) + 1 - len(needle)):
            if haystack[i: i + len(needle)] == needle:
                return i
        return -1