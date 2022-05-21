class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle==None:
            return 0 
        return haystack.find(needle)