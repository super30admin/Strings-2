#Time Complexity : O(n*m) where n is the length of the haystack and m is the length of the needle
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        #handle edge cases
        if (not needle and not haystack) or (haystack and not needle):
            return 0
        n = len(needle)

        for i in range(len(haystack)-n+1):
            #check if first letter of needle is equal to curr char in haystack, if so check if substring of haystack is equal to the needle
            if haystack[i] == needle[0] and haystack[i:i+n] == needle:
                return i

        return -1
