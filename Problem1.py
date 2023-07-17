# Time Complexity : O(m+n) where n and m is the number of characters in the haystack and needle
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#  
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        target = 0
        for c in needle:
            target = (target * 26) + (ord(c)-ord('a'))
        
        window = 0
        for i in range(len(haystack)):
            window = (window * 26) + (ord(haystack[i])-ord('a'))
            if i >= len(needle):
                window = window - ((ord(haystack[i-len(needle)])-ord('a')) * (26**(len(needle))))
            if target == window and i >= len(needle)-1:
                return i-len(needle)+1
            i+=1
        return -1
            