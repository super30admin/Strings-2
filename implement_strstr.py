# -*- coding: utf-8 -*-
"""
TC: O(N) where N is the length of the longer string
SC: O(1) no extra space used
"""

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        #Edge cases
        if len(needle) == 0:
            return 0
        
        if len(haystack) < len(needle):
            return -1
        
        #take the length of haystak and needle
        h = len(haystack)
        n = len(needle)
        
        #traverse through haystack string and match the contents with needle string
        #return the index if found, else -1
        for i in range(0, h - n + 1):
            if haystack[i:i+n] == needle:
                return i
        
        return -1
        