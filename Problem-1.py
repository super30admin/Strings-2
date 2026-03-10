# Time Complexity : O(n * m), n = len(haystack), m = len(needle) (for naive search)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Check if needle exists in haystack using built-in `in`.
# 2. If it exists, return the first index using `find`.
# 3. Otherwise, return -1.

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle in haystack:
            return haystack.find(needle)
        return -1