#Time Complexity: O(n)
#Space Complexity:O(1)

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        n = len(needle)
        for pointer in range(len(haystack)):
            end = pointer+n
            if haystack[pointer:end] == needle:
                return pointer
        return -1
