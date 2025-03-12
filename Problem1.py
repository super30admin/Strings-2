#time complexity o(m)
#space complexity o(1)

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m = len(haystack)
        n = len(needle)
        k = 26 ** (n -1)
        needlehash = 0
        if n == 0:
            return 0
        for i in range(n):
            needlehash = needlehash * 26 + (ord(needle[i]) - ord('a') + 1)
        
        sourcehash = 0
        #start processing the source
        for i in range(m):
            #out
            if i >= n:
                out = haystack[i-n]
                sourcehash = sourcehash - (ord(out) - ord('a')+ 1) * k
            
            #in
            In = haystack[i]
            sourcehash = sourcehash * 26 + (ord(In) - ord('a') + 1)

            if i >= n - 1 and sourcehash == needlehash:
                return i - n + 1
        return -1


        