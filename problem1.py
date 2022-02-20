#Time Complexity O(N)
#Space Complexity O(1)

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle in haystack:
            return haystack.index(needle)
        return -1
       
