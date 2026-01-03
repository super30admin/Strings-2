"""
Base case of empty should return 0 (mentioned in question). then we check for the range for the len of needle in the haystack (a window like approach) and then check if that
lenght is equal to the haystack, return its index i, else -1
TC is o(n*m) for len of needle and haystack and space is o(1) 
"""

class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        #base
        if needle == "":
            return 0
        for i in range(len(haystack) - len(needle) + 1):
            if haystack[i : i + len(needle)] == needle:
                return i
        return -1