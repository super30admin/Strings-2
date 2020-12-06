"""
Time Complexity:    O(m+n) where m is size of needle and n is size of haystack
Space Complexity:   O(n) for lps
#Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach
KMP algorithm focuses on finding repeated prefix and suffix and their index to avoid starting the match 
from index 0 everytime. Hence we create an LPS array of the index of prefix and suffix matching index 
for needle and accordingly traverse the haystack. 
"""


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if not needle:
            return 0
        m = len(haystack)
        n = len(needle)
        lps = self.lps(needle)
        if m < n:
            return -1
        i = 0
        j = 0
        while i < m:
            if haystack[i] == needle[j]:
                i += 1
                j += 1
                if j == n:
                    return i-j
            else:
                if j == 0:
                    i += 1
                else:
                    j = lps[j-1]
        return -1

    def lps(self, needle):
        j = 0
        i = 1
        lps = [0]*len(needle)
        while i < len(needle):
            if needle[i] == needle[j]:
                j += 1
                lps[i] = j
                i += 1
            elif j > 0 and needle[i] != needle[j]:
                j = lps[j-1]
            elif j == 0 and needle[i] != needle[j]:
                lps[i] = 0
                i += 1
        return lps
