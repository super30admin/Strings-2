"""
TC: O(MN
"""
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        n = len(needle)
        for idx, s in enumerate(haystack):
            if s == needle[0]:
                j = 0
                k = idx
                while j < len(needle) and k < len(haystack) :
                    if haystack[k] == needle[j]:
                        k += 1
                        j += 1
                    
                    else:
                        break
                if j == len(needle):
                    return idx
        
        return -1
        
