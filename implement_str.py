# Time Complexity: O(m+ n)
# Space Complexity: O(1)
class Solution:
    def lps(self, needle):
        lps = [-1] * len(needle)
        j = 0
        i = 1
        while i < len(needle):
            if needle[i] == needle[j]:
                j += 1
                lps[i] = j
                i += 1
            elif needle[i] != needle[j] and j > 0:
                j = lps[j - 1]
            elif needle[i] != needle[j] and j == 0:
                lps[i] = 0
                i += 1
        return lps

    def strStr(self, haystack, needle):
        if len(needle) == 0:
            return 0

        m = len(haystack)
        n = len(needle)

        i = 0  # for haystack
        j = 0  # for needle
        lps = self.lps(needle)
        while i < m:
            if haystack[i] == needle[j]:
                i += 1
                j += 1
                if j == n:
                    return i - n
            elif haystack[i] != needle[j] and j > 0:
                j = lps[j - 1]
            elif haystack[i] != needle[j] and j == 0:
                i += 1
        return -1

