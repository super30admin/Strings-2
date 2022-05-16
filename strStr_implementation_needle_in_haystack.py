# Leetcode 28 https://leetcode.com/problems/implement-strstr/

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle == "":
            return 0
        #establish a search window equal to the length of needle
        for i in range(len(haystack)+1 - len(needle)):
            if haystack[i:i+len(needle)] == needle:
                return i
        return -1
    
    #TC: O(n*m) n = length of haystack, m is the length of needle SC: O(1)
            