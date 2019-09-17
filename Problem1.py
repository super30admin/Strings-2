# Time Complexity : O(n) when n is length of string haystack
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        needle_len = len(needle)
        haystack_len = len(haystack)
        # If needle is null then return 0
        if needle_len == 0:
            return 0
        # Till the lenght of haystack_len- needle_len+1 is the substring in haystact is equal to needle
        # If yes then return the index else continue
        for i in range(haystack_len - needle_len + 1):
            if haystack[i:i + needle_len] == needle:
                return i
        # If needle is not present in haystact then return -1
        return -1
