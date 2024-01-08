"""
Time Complexity : O(m+n) where m is the length of haystack and n is the length of needle. 
Space Complexity : O(n) where n is the length of the needle nad used for lps

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
Implement KMP pattern search algorithm
For every character in string count: 
longest matching prefix without considering last character == longest matching suffix without considering first character

for example string = a a a b a a a
               lps = 0 1 2 0 1 2 3
"""


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m = len(haystack)
        n = len(needle)
        if n > m:
            return -1
        lps = self.calculatelps(needle)

        i = 0  # haystack pointer
        j = 0  # needle pointer

        while i < m:
            if haystack[i] == needle[j]:
                i += 1
                j += 1
            elif haystack[i] != needle[j] and j > 0:
                j = lps[j-1]
            elif haystack[i] != needle[j] and j == 0:
                i += 1
            if j == n:
                return i - n
        return -1

    def calculatelps(self, needle):
        i = 1
        j = 0
        n = len(needle)
        lps = [0] * n

        while i < n:
            if needle[i] == needle[j]:
                j += 1
                lps[i] = j
                i += 1
            elif needle[j] != needle[i] and j > 0:
                j = lps[j-1]
            elif needle[j] != needle[i] and j == 0:
                lps[i] = 0
                i += 1

        return lps
