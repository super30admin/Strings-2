class Solution:
    def lps(self,needle):
        lps = [0] * len(needle)
        i, j = 1, 0
        while i < len(needle):
            if needle[i] == needle[j]:
                j += 1
                lps[i] = j
                i += 1
            elif needle[i] != needle[j] and j > 0:
                j = lps[j - 1]
            elif needle[i] != needle[j] and j > 0:
                lps[i] = 0
                i += 1
        return lps

    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle) == 0:
            return 0
        m, n = len(haystack), len(needle)
        i, j = 0, 0  # i is the source and j is the pattern
        lps = []
        lps = self.lps(list(needle))
        while i < m:
            if haystack[i] == needle[j]:
                i += 1
                j += 1
                if j == n:
                    return i - n
            elif haystack[i] != needle[j] and j > 0:
                if j > 0:
                    j = lps[j-1]
            elif haystack[i] == needle[j] and j == 0:
                #lps[i] = 0
                i += 1
        return -1



# TC = O(N)
# Space complexity : List LPS O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : took a while to understand
