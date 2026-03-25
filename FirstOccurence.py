# Time Complexity : O(n + m) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach:
# Use Rabin-Karp with rolling hash + modulo to avoid overflow.
# Compute hash of needle.
# Maintain rolling hash for window in haystack:
#   1. Add incoming character
#   2. Remove outgoing character when window exceeds size
#   3. Use modulo at every step
# If hash matches, verify substring to avoid collision.

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m = len(haystack)
        n = len(needle)

        if n == 0:
            return 0
        if n > m:
            return -1

        base = 26
        mod = 10**9 + 7

        pattern_hash = 0
        window_hash = 0
        power = pow(base, n, mod)   
        for i in range(n):
            pattern_hash = (pattern_hash * base + (ord(needle[i]) - ord('a') + 1)) % mod

        for i in range(m):
            window_hash = (window_hash * base + (ord(haystack[i]) - ord('a') + 1)) % mod
            if i >= n:
                outgoing = (ord(haystack[i - n]) - ord('a') + 1)
                window_hash = (window_hash - outgoing * power) % mod
            if i >= n - 1 and window_hash == pattern_hash:
                if haystack[i - n + 1 : i + 1] == needle:
                    return i - n + 1

        return -1