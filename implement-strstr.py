# Time Complexity : O(m + n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m = len(haystack)
        n = len(needle)
        needle_hash = 0
        MOD = 10**9 + 7

        for i in range(0,n):
            needle_hash = (needle_hash*26 + (ord(needle[i]) - ord('a') + 1)) % MOD

        source_hash = 0
        k = pow(26, n-1)
        for i in range(0,m):
            if i >= n:
                out_element = ord(haystack[i - n]) - ord('a') + 1
                source_hash = (source_hash - (out_element * k)) % MOD

            in_element = ord(haystack[i]) - ord('a') + 1
            source_hash = (source_hash * 26 + in_element) % MOD

            if source_hash == needle_hash:
                return i - n + 1
        return -1

