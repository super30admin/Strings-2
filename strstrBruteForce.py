class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        
        if len(needle) == 0:
            return 0
        
        m,n = len(haystack),len(needle)
        i = 0
        
        while i< m-n+1:
            if haystack[i] == needle[0]:
                k = i
                j = 0
                while j<m and k<m and haystack[k] == needle[j]:
                    k+=1
                    j+=1
                    if j == n:
                        return i
            i+=1
        
        return -1
        
