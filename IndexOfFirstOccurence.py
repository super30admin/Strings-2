# Problem1 Implement strStr() (https://leetcode.com/problems/implement-strstr/)

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m = len(haystack)
        n = len(needle)
        if n > m:
            return -1
        needleHash = 0
        for i in range(n):
            c = needle[i]
            needleHash = (needleHash * 26) + (ord(c) - 96)
        haystackHash = 0
        k = 26 ** (n - 1)
        for i in range(m):
            if i >= n:
                outgoing = haystack[i - n]
                haystackHash = haystackHash - (ord(outgoing) - 96) * k
            incoming = haystack[i]
            haystackHash = (haystackHash * 26) + (ord(incoming) - 96)
            if haystackHash == needleHash:
                return i - n + 1
        return -1
# Time complexity O(n)
# Space complexity O(1)