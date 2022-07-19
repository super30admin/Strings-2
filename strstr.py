#Time complexity: O(m)
#Space complexity: O(n); no of unique chars in needle

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        
        m = len(haystack)
        n = len(needle)
        
        if m < n:
            return -1
        lps = self.lps(needle)
        i = 0 # haystack ptr
        j = 0 # needle ptr
        
        while i < m:
            if haystack[i] == needle[j]:
                i += 1
                j += 1
            elif haystack[i] != needle[j] and j > 0:
                j = lps[j-1]
            elif haystack[i] != needle[j] and j == 0:
                i += 1
            if j == n:
                return i-n
            
        return -1
                
    
    def lps(self, needle):
        j = 0
        i = 1
        n = len(needle)
        lps = [0 for _ in range(n)]
        
        while i < n:
            if needle[i] == needle[j]:
                j += 1
                lps[i] = j
                i += 1
            elif needle[i] != needle[j] and j > 0:
                j = lps[j-1]
            elif needle[i] != needle[j] and j == 0:
                lps[i] = 0
                i += 1
        return lps
                
        
       
