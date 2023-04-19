# Brute Force
# Time Complexity - O(m*n)
# Space Complexity - O(1)
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        n = len(haystack)
        m = len(needle)

        for i in range(n):
            if haystack[i] == needle[0]:
                j = i 
                k = 0 
                while k < m and j < n: 
                    if haystack[j] == needle[k]:
                        j+= 1 
                        k+= 1 
                    else :
                        break
                if k == m : 
                    return i
        return -1 

# Robin-Karp Algorithm
# Time Complexity -O(m+n)
# Space Complexity - O(1)
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        n = len(haystack)
        m = len(needle)
        k = 26
        hashneedle = 0
        hashhay = 0
        power = pow(k,m)

        for i in range(m):
            hashneedle = hashneedle * k + (ord(needle[i])+1- ord('a'))

        for i in range(n):
            # in 
            hashhay = hashhay *k + (ord(haystack[i]) +1 - ord('a'))

            # out 
            if i >= m:
                out = i-m 
                hashhay = hashhay - (power)* (ord(haystack[out]) +1 - ord('a')) 

            if hashhay == hashneedle : 
                    return i-m + 1
        return -1 