"""
Author: Srindihi Bhat
Did it run on LC: Yes
Time Complexity: O(len(hackstack)) -Iterating throught Haystack
Space Complexity: O(1) - Constant Extra Space

Logic:
Sliding window and checking if all chars in the sliding window match
"""

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(haystack)==0 and len(needle)==0:
            return 0
        
        hay_len, needle_len = len(haystack), len(needle)
        
        for i in range(hay_len-needle_len+1):
            if haystack[i:i+needle_len] == needle:
                return i
        
        return -1
            