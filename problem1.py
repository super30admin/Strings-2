# Time Complexity : O(m+n)
# # Space Complexity:o(n)
# #  Did this code successfully run on Leetcode : Yes

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle is None or len(needle) == 0:
            return 0

        m = len(haystack)
        n = len(needle)

        needleArr = self.getKMP(needle)

        i = int(0)
        j = int(0)

        while i < m:
            if needle[j] == haystack[i]:
                i += 1
                j += 1

                if j == n:
                    return i - n

            elif needle[j] != haystack[i] and j > 0:
                j = needleArr[j - 1]

            else:
                i += 1

        return -1

    def getKMP(self, needle: str):
        n = len(needle)
        retArr = [None] * n

        i = 1
        j = 0

        retArr[0] = 0

        while i < n:
            if needle[i] == needle[j]:
                j += 1
                retArr[i] = j
                i += 1

            elif needle[i] != needle[j] and j > 0:
                j = retArr[j - 1]

            else:
                retArr[i] = 0
                i += 1

        return retArr
