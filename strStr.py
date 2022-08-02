# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle not in haystack and len(needle)>len(haystack):
            return -1
        i = 0
        n = len(needle)
        while i < len(haystack) and n <= len(haystack):
            val = slice(i,n)
            if haystack[val] == needle:
                return i
            i += 1
            n += 1
        return -1
