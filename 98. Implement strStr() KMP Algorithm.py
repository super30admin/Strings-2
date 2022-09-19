class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle) == 0:
            return 0
        m = len(haystack)
        n = len(needle)
        i = 0  # haystack  i.e source string
        j = 0  # needle i.e pattern string
        lps = self.lps(needle)
        while i < m:
            if haystack[i] == needle[j]:
                i += 1
                j += 1
                if j == n:
                    return i - n
            elif haystack[i] != needle[j] and j > 0:
                j = lps[j - 1]
                print(j)
            elif haystack[i] != needle[j] and j == 0:
                i += 1
        return -1

    def lps(self, needle):
        lps = [0] * len(needle)
        lps[0] = 0
        i = 1
        j = 0
        while i < len(needle):
            if needle[i] == needle[j]:
                j += 1
                lps[i] = j
                i += 1
            elif needle[i] != needle[j] and j > 0:
                j = lps[j - 1]
            elif needle[j] != needle[i] and j == 0:
                lps[i] = 0
                i += 1
        return lps

# TC = O(M+N)
# Space complexity : List LPS O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
