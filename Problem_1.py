# Brute force solution with TLE
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m, n = len(haystack), len(needle)
        if n == 0:
            return 0
        i = 0
        while i < m -n + 1:
            if haystack[i] == needle[0]:
                k = i
                j = 0
                while k < m and j < n and haystack[k] == needle[j]:
                    k += 1
                    j += 1
                    if j == n:
                        return i
            i += 1
        
        return -1

# Time Complexity: O(m * n)
# Space Complexity: O(1)



# KMP Algorithm
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m, n = len(haystack), len(needle)
        if n == 0:
            return 0
        lps = self.lpsFunc(needle)
        i, j = 0, 0
        while i < m:
            if haystack[i] == needle[j]:
                i += 1
                j += 1
                if j == n:
                    return i - j
            elif haystack[i] != needle[j]:
                if j > 0:
                    j = lps[j-1]
                else:
                    i += 1
                    
        return -1
    
    def lpsFunc(self, needle):
        lps = [0] * len(needle)
        j, i = 0, 1
        while i < len(needle):
            if needle[i] == needle[j]:
                j += 1
                lps[i] = j
                i += 1
            elif needle[i] != needle[j]:
                if j > 0:
                    j = lps[j-1]
                else:
                    lps[i] = 0
                    i += 1
        return lps

# Time Complexity: O(m + n)
# Space Complexity: O(1)

        
        