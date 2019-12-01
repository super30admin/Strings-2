# time complexity:O(MN)
# space complexity:O(N)
# leetcode:accepted
# explination: you create a kmp array and depending on that u need traverse threough the string
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        s = haystack
        p = needle
        n = len(haystack)
        m = len(needle)
        if m == 0:
            return 0
        KMP = self.KMP(p, m)
        i = 0
        j = 0
        while i < n:
            if s[i] == p[j]:
                j = j + 1
                i = i + 1
            if j == m:
                return i - j
            elif i < n and s[i] != p[j] and j > 0:
                j = KMP[j - 1]

            elif i < n and s[i] != p[j] and j == 0:
                i = i + 1
        return -1

    def KMP(self, p, m):
        KMP = [0 for _ in range(m)]
        i = 1
        j = 0
        while i < m:

            if p[i] == p[j]:
                j = j + 1
                KMP[i] = j
                i = i + 1

            elif p[i] != p[j] and j > 0:
                j = KMP[j - 1]

            elif p[i] != p[j] and j == 0:
                j = KMP[j - 1]
                i = i + 1
        print(KMP)
        return KMP

