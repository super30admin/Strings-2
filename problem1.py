#Time Complexity : O((n - m) * m), where n is the length of the haystack string and m is the length of the needle string
#Space Complexity :O(1),
#Did this code successfully run on Leetcode : yes


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle == "":
            return -1

        for i in range(len(haystack) - len(needle) + 1):
            if haystack[i] == needle[0]:
                if haystack[i:i+len(needle)] == needle:
                    return i
        return -1
        