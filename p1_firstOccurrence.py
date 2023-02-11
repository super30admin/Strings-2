#28. Find the Index of the First Occurrence in a String


# // Time Complexity : O(n.m) # n = length of haystack m = len of needle
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        n = len(haystack) 
        m = len(needle)
        if n == 0 or n == 0: return -1
        for i in range(n-m+1): # O(n.m) # n = length of haystack m = len of needle
            if haystack[i] == needle[0]:
                j = 0
                while j < m:
                    if haystack[i+j] != needle[j]:
                        break
                    j += 1
                    if j == m: # if the complete word is found
                        return i
        return -1