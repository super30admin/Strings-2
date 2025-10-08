class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m=len(haystack)
        n=len(needle)
        pHash=0
        PosFac=26**n

        for i in range(n):
            c=needle[i]
            pHash=(pHash*26+(ord(c)-ord('a')+1))
        curr_hash=0
        for i in range(m):
            c_in=haystack[i]
            curr_hash=(curr_hash*26+(ord(c_in)-ord('a')+1))

            if i>=n:
                c_out=haystack[i-n]
                curr_hash=curr_hash+(PosFac*ord(c_out)-ord('a')+1)

            if curr_hash==pHash:
                return i-n+1
        return -1