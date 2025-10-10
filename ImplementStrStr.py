#Time Complex: O(m*n) where m is the lenght of haystack and n is the length of needle
#Spack is O(1)

# Intuition is to use two pointer and check if elements are equal, if we cross the length of p then return the first index
# If not then restart the j pointer to 0 for needle string and increment the k pointer by 1

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle) > len(haystack): return -1
        j = 0
        k = 0
        while k <= len(haystack) - len(needle):
            i = k
            while haystack[i] == needle[j]:
                if j >= len(needle) - 1:
                    return i - len(needle) + 1
                i += 1
                j += 1
            else:
                k += 1
                j = 0
        return -1


    # Using Robin karp algo, we can compare the hash of strings in O(1) time, hence overall complexity becomes O(m+n)
    def strStrRobinKarp(self, haystack: str, needle: str) -> int:
        nHash = 0
        m = len(haystack)
        n = len(needle)

        posFac = 26 ** n

        for c in needle:
            print(ord(c) - ord('a'))
            nHash = (26 * nHash + (ord(c) - ord('a') + 1))

        currHash = 0

        for i in range(m):
            inEle = haystack[i]
            currHash = (currHash * 26 + (ord(inEle) - ord('a') + 1))

            if i >= n:
                outEle = haystack[i - n]
                currHash = (currHash - (posFac * (ord(outEle) - ord('a') + 1)))

            if currHash == nHash:
                return i - n + 1

        return -1

