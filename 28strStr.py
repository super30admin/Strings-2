class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        
        
        hay_len = len(haystack)
        need_len = len(needle)
        
        for i in range(hay_len-need_len+1):
            if needle == haystack[i:i+need_len]:
                return i
            
        return -1