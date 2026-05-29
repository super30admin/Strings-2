class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m = len(haystack)
        n = len(needle)

        pHash = 0
        posFac = 26 ** n

        for i in range(n):
            c = needle[i]
            pHash = (pHash * 26 + (ord(c) - ord('a') + 1))

        currHash = 0

        for i in range(m):
            c_in = haystack[i]
            currHash = (currHash * 26 + (ord(c_in) - ord('a') + 1))

            if i >= n:
                c_out = haystack[i - n]
                currHash = (currHash - (posFac * (ord(c_out) - ord('a') + 1)))

            if currHash == pHash:
                return i - n + 1

        return -1

# Time: O(m + n) 
# Space: O(1)