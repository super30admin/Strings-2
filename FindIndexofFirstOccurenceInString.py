# brute force
# class Solution:
#     def strStr(self, haystack: str, needle: str) -> int:
#         i,j,m,n=0,0,len(haystack),len(needle)
#         while i<=m-n:
#             if haystack[i] == needle[0]:
#                 k = i
#                 j = 0
#                 while haystack[k] == needle[j]:
#                     j+=1
#                     k+=1
#                     if j == n:
#                         return i
#             i+=1
#         return -1


# class Solution:
#     def strStr(self, haystack: str, needle: str) -> int:
#         m, n = len(haystack), len(needle)
#         if n>m : return -1
#         hi,k,ho = 0,26,0
#         # for incoming
#         for i in range(n):
#             c = needle[i]
#             hi = hi*k +(ord(c) - ord('a') + 1)
#         # for outgoing
#         for i in range(m):
#             if i>=n:
#                 # reduce contribution of outgoing
#                 ho = ho%pow(k,n-1)
#             b = haystack[i]
#             ho=ho*k+(ord(b)-ord('a') +1)
#             if ho==hi: return i-n+1
#         return -1

# 
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m, n = len(haystack), len(needle)
        if n > m:
            return -1

        base = 256  # Wider base to reduce collisions
        mod = 10**9 + 7  # Large prime to avoid overflow and reduce collisions

        # Compute hash for needle
        needle_hash = 0
        for ch in needle:
            needle_hash = (needle_hash * base + ord(ch)) % mod

        # Compute hash for first window in haystack
        window_hash = 0
        for i in range(n):
            window_hash = (window_hash * base + ord(haystack[i])) % mod

        if window_hash == needle_hash :
            return 0

        # Precompute (base^n-1) % mod
        power = pow(base, n - 1, mod)

        # Slide the window
        for i in range(n, m):
            # Remove leftmost char
            window_hash = (window_hash - ord(haystack[i - n]) * power) % mod
            # Add rightmost char
            window_hash = (window_hash * base + ord(haystack[i])) % mod

            # Check hash match
            if window_hash == needle_hash:
                return i - n + 1

        return -1
        
        