# Time complexity - o(m+n)
# Space complexity - o(1)

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:

        k = 26
        m = len(haystack)
        n = len(needle)

        if n>m:
            return -1

        prevHash = 0

        for i in range(n):
            prevHash = prevHash*k + (ord(needle[i])-ord('a')+2)

        l = 0

        mHash = 0
        for r in range(m):
            
            if r-l>=n:
                mHash = mHash%(k**(n-1))
                l+=1

            mHash = mHash*k+ (ord(haystack[r])-ord('a')+2)
            if prevHash == mHash:
                return l

        return -1



