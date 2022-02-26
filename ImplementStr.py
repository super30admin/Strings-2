"""
Implement strStr().

Return the index of the first occurrence of needle in haystack, 
or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string?
 This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 
when needle is an empty string. 
This is consistent to C's strstr() and Java's indexOf().

"""

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on VScode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:

        l = 0

        r = len(needle) - 1

        while(r < len(haystack)):
            
            if haystack [l : r+1] == needle:
                return l
            else:
                l +=1
                r +=1
                
        return -1