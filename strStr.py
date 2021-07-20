# Time Complexity : O(m) - len of haystack
# Space Complexity : O(n) - len of needle
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


#kmp algo
#lowest common prefix suffix
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle) == 0:
            return 0
        m = len(haystack)
        n = len(needle)

        i,j = 0,0

        lps = self.lps(needle)

        while i < m:
            if haystack[i] == needle[j]:
                i += 1
                j += 1
                if j == n:
                    return i - len(needle)
            elif haystack[i] != needle[j] and j > 0:
                j = lps[j-1]
            elif haystack[i] != needle[j] and j == 0:
                i += 1
        return -1


    def lps(self,needle):
        j,i = 0,1
        lps = [0]*len(needle)
        while i < len(needle):
            if needle[i] == needle[j]:
                j += 1
                lps[i] = j
                i += 1
            elif needle[i] != needle[j] and j > 0:
                j = lps[j-1]
            elif needle[i] != needle[j] and j == 0:
                lps[i] = 0
                i += 1

        return lps 