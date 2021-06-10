# TC: O(M x N) where M = length of haystack and N = length of needle. 
# SC: O(1) since we do not use any extra space.

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if not needle or len(needle) == 0: 
            return 0
        
        if len(needle) > len(haystack): 
            return -1
        
        i = 0
        h = len(haystack)
        n = len(needle)
        while (i < (h - n) + 1): 
            if haystack[i] == needle[0]: 
                k = i
                j = 0
                while haystack[k] == needle[j] and j < n: 
                    if j == n - 1: 
                        return i
                    k += 1
                    j += 1
            i += 1
        return -1
                    
