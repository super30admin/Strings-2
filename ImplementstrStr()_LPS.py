# TC: O(M + N) where M is length of the haystack string and N is the length of the needle. 
# SC: O(N) where N is the space for LPS array.

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if not needle or len(needle) == 0: 
            return 0
        
        if len(needle) > len(haystack): 
            return -1
        
        n = len(needle)
        h = len(haystack)
        
        def lps(needle, n): 
            i = 0
            j = i + 1
            lps = [0] * n
            while j < n: 
                if needle[i] == needle[j]: 
                    lps[j] = i + 1
                    i += 1
                    j += 1
                elif needle[i] != needle[j] and i > 0: 
                    i = lps[i - 1]
                elif needle[i] != needle[j] and i == 0: 
                    lps[j] = 0
                    j += 1
            
            return lps
        
        lps_main = lps(needle, n)
        i = 0 
        j = 0
        
        while i < h: 
            if haystack[i] == needle[j]:
                if j >= n - 1: 
                    return i - n + 1
                
                i += 1
                j += 1
            elif haystack[i] != needle[j] and j > 0: 
                j = lps_main[j - 1]
            
            elif haystack[i] != needle[j] and j == 0: 
                i += 1
            
        return -1
