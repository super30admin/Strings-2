# Using Brute Force
# Time: O(m*n)
# Space: O(1)

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        
        m = len(haystack)
        n = len(needle)
        
        i = 0
        j = 0
        
        while i <= (m-n):
            if haystack[i] == needle[j]:
                k = i
                while haystack[k] ==  needle[j]:
                    k += 1
                    j += 1
                    if j == n:
                        return i
                j = 0
            i += 1
        return -1
                 