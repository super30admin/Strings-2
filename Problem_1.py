# https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/

# Time complexity: O(n + m) 
# Space complexity: O(1)
# Explanation: Use sliding window to find the first occurance that matches needle and return; otherwise return -1

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m, n = len(needle), len(haystack)
        for w in range(n - m + 1):
            for i in range(m):
                if needle[i] != haystack[w + i]:
                    break
                if i == m - 1:
                    return w

        return -1
                
