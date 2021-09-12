"""
Time Complexity : O(m+n) where m and n are lengths of haystack and needle strings respectively 
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle) == 0:
            return 0
        m = len(haystack)
        n = len(needle)
        i = j = 0
        lps = self.LPS(needle)
        # We traverse through the haystack array and use the lps array to check the 
        # matching prefix and suffic if matched we increment both i and j. If they
        # don't match and pointer of needle string is at index greater than 0 we
        # simply move j to the value of lps at one index less than current j. In 
        # other case we increment the pointer in haystack. Also if pointer in needle
        # is equal to the length of needle we return the value of diff between 
        # haystack pointer and length of needle string.
        while i < m:
            if haystack[i] == needle[j]:
                i += 1
                j += 1
                if j == n: return i - n
            elif haystack[i] != needle[j] and j > 0:
                j = lps[j - 1] 
            else:
                i += 1
        return -1
    # Longest Prefix Suffix algo (KMP Algorithm)
    def LPS(self, needle):
        lps = [0]*len(needle) 
        i = 1
        j = 0
        # Traverse till the end of needle string
        while i < len(needle):
            # If the prefix is equal suffix we increment j and capture value j in 
            # lps array. If they aaren't equal and j greater than 0 we note the j at 
            # index less than current and in other case we set the lps to 0 and 
            # increment i pointer
            if needle[i] == needle[j]:
                j += 1
                lps[i] = j 
                i += 1
            elif needle[i] != needle[j] and j > 0:
                j = lps[j - 1]
            else:
                lps[i] = 0
                i += 1
        return lps