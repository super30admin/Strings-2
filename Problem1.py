#Time Complexity :- O(n)
#Space Complexity :- O(1)
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        n = len(needle)
        for i in range(len(haystack)):
            if needle[0] == haystack[i]:
                if haystack[i:i+n] == needle:
                    return i
        return -1

