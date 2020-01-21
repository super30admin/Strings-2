# Runs on Leetcode
    # Runtime - O(m+n)

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m = len(haystack)
        n = len(needle)
        if not n:
            return 0
        if m < n:
            return -1
        lps = self.lps(needle, len(needle))
        i = 0
        j = 0
        while i < m:
            if haystack[i] == needle[j]:
                i += 1
                j += 1
            if j == n:
                return i-j
            elif i < m and j > 0 and haystack[i] != needle[j]:
                j = lps[j-1]
            elif i < m and j == 0 and haystack[i] != needle[j]:
                i += 1
        return -1
    
    def lps(self, pattern, n):
        lps = [0 for i in range(n)]
        i = 1
        j = 0
        lps[0] = 0
        while i < n:
            # case1
            if pattern[j] == pattern[i]:
                j += 1
                lps[i] = j
                i += 1
            # case2
            elif j > 0 and pattern[j] != pattern[i]:
                j = lps[j-1]
            # case3
            elif j == 0 and pattern[j] != pattern[i]:
                lps[i] = j
                i += 1
        return lps
