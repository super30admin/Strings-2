# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
We find the first occurence of needle within haystack by iterating over the haystack and checking if the first character of 
needle matches the current character in haystack. If it does, we check if the substring of haystack from the current index 
to the length of needle is equal to needle.
"""

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle == None or haystack == None: return None

        for index, char in enumerate(haystack):
            if not char == needle[0]: continue
            if haystack[index: index + len(needle)] == needle: return index

        return -1