# -*- coding: utf-8 -*-
"""
Algorithm - Sliding window concept

Step 1: Declare lengthNeedle (to store length of needle), lengthHaystack(to store length of haystack)
        and windowStartPos(start position of window) and windowEndPos (end position of window) and initialize it with
        0 and lengthNeedle respectively for first iteration in while loop.
Step 2: Check for the base case if lengthNeedle == 0, return 0
Step 3: C

"""

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
      
        lengthNeedle = len(needle) 
        lengthHaystack = len(haystack)
        
        windowStartPos = 0 # Starting position of window
        windowEndPos = lengthNeedle # ending position of window
        # base case
        if(lengthNeedle == 0):
            return 0
        while (windowStartPos <= lengthHaystack - lengthNeedle):   
            if (haystack[windowStartPos:windowEndPos] == needle):
                return windowStartPos
            else:
                windowStartPos = windowStartPos +1
                windowEndPos = windowEndPos + 1
            
        return -1
            
        