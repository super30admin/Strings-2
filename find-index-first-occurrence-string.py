"""
Robin Karp Implementation
Time - O(n * m)
Space - O(1)
"""
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        n, m = len(haystack), len(needle)
        if m == 0:
            return 0
        if m > n:
            return -1

        base = 256
        mod = 10**9 + 7
        needle_hash = 0
        window_hash = 0
        for i in range(m):
            needle_hash = (needle_hash * base + ord(needle[i])) % mod
            window_hash = (window_hash * base + ord(haystack[i])) % mod


        high_base = pow(base, m - 1, mod)

        for i in range(n - m + 1):
            if needle_hash == window_hash:
                if haystack[i:i + m] == needle:
                    return i
            if i < n - m:

                window_hash = (window_hash - ord(haystack[i]) * high_base) % mod
                window_hash = (window_hash * base + ord(haystack[i + m])) % mod
                window_hash = (window_hash + mod) % mod 

        return -1
