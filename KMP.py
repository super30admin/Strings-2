# Time complexity : O(n)
# Space complexity : O(n)
# Leetcode : Solved and submitted

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        # find the length of haystack and needle
        m = len(haystack)
        n = len(needle)
        # starting index of i for haystack and j for needle
        i = j = 0
        
        # call the lps function for needle to calculate the longest common prefix suffix for needle
        lps = self.lps(needle, n)
        
        # traversing until the end of haystack string
        while i < m:
            # if the char matched, then increment the haystack and needle pointer
            if haystack[i] == needle[j]:
                j += 1
                i += 1
                # if we have reached the end of the needle string, then return the starting index in haystack
                if j == n:
                    return i - n
            # if the value of j is greater than 0 and char doesn't match, then move j to the longest common suffix and prefix that we calculated
            elif j > 0 and haystack[i] != needle[j]:
                j = lps[j-1]
            # if we already at the first chracter of needle string, and the character doesn't match, then simply increment the pointer in haystack
            elif j == 0 and haystack[i] != needle[j]:
                i += 1
        return -1
    
    def lps(self, needle, n):
        # create an array of 0 of length of the string needle
        lps = [0 for _ in range(n)]
        i = 1
        j = 0
        # traversing until the length of the string
        while i < n:
          # if char matched, then increment the j pointer, place the longest common prefix suffix at the i'th index in lps, and increment i as well
            if needle[i] == needle[j]:
                j += 1
                lps[i] = j
                i += 1
            # if we are at index greater than 0 and chars doesn't match, then move j to the longest matching sequence until now
            elif j > 0 and needle[i] != needle[j]:
                j = lps[j-1]
             # if we are at the 0th index, then move j back to one steo back and increment i
            elif j == 0 and needle[i] != needle[j]:
                j = lps[j-1]
                i += 1
        return lps
