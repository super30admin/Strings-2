# Time Complexity: O((m - n) * n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        m = len(haystack)
        n = len(needle)
        for i in range(m - n + 1):
            if haystack[i:(i + n)] == needle:
                return i
        return -1