# Time complexity: O(M*M+N), M=len(needle) and N=len(haystack)
# Space complexity:O(M), M=len(needle)
class Solution:
    def strStr(self, haystack, needle) :

        if len(needle) == 0:
            return 0

        if len(haystack) < len(needle):
            return -1

        lps = self.lps(needle)
        i = 0
        j = 0
        m = len(haystack)
        n = len(needle)

        while i < m:
            # i==j
            if haystack[i] == needle[j]:
                i += 1
                j += 1

                if j == n:
                    return i - n

            else:
                # j>0
                if j > 0:
                    j = lps[j - 1]
                # j==0
                elif j == 0:
                    i += 1
        return -1

    def lps(self, needle):
        lps = [0 for x in range(len(needle))]
        i = 1
        j = 0

        while i < len(needle):
            # i==j
            if needle[i] == needle[j]:
                j += 1
                lps[i] = j
                i += 1
            # i!=j and j>0
            else:
                if j > 0:
                    j = lps[j - 1]

                # i!=j and j==0
                elif j == 0:
                    lps[i] = 0
                    i += 1
        return lps

