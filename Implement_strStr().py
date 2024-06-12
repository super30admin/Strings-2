# -*- coding: utf-8 -*-
"""
Algorithm - Sliding window concept

Step 1: Declare lengthNeedle (to store length of needle), lengthHaystack(to store length of haystack)
        and windowStartPos(start position of window) and windowEndPos (end position of window) and initialize it with
        0 and lengthNeedle respectively for first iteration in while loop.
Step 2: Check for the base case if lengthNeedle == 0, return 0
Step 3: Start a while loop and iterate through it till the condition windowStartPos <= lengthHaystack - lengthNeedle
        is true
Step 4: Check if the string from the starting position of window i.e. windowStartPos till windowEndPos is same as string needle
        if yes, return the window starting position i.e. windowStartPos else increment windowStartPos and windowEndPos by 1
Step 5: Once we are out of loop, that means we did not find any string same as expected, so we return -1 in that case

Time Complexity - O(N)
Space Complexity - O(1)

Code accepted in leetcode

Doubt - Is writing "haystack[windowStartPos:windowEndPos] == needle" this way considered as language feature or is it fine 
        to use this way

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
            
        