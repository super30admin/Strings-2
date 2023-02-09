class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle in haystack:
            h=haystack.index(needle)
            return h
        else:
            return -1
        