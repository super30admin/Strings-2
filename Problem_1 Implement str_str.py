# // Time Complexity : O(2n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m = len(haystack)
        n = len(needle)
        i = 0
        j = 0
        if n == 0: return 0
        if m == 0: return -1

        lps = self.helper(needle)

        while i < m:
            if haystack[i] == needle[j]:
                i = i + 1
                j = j + 1
                if j == n:
                    return i - n
            elif haystack[i] != needle[j] and j > 0:
                j = lps[j - 1]
            elif haystack[i] != needle[j] and j == 0:
                i += 1
        return -1

    def helper(self, needle):
        lps = [0 for x in range(len(needle))]
        i = 1
        j = 0
        while i < len(needle):
            # case1
            if needle[i] == needle[j]:
                j += 1
                lps[i] = j
                i += 1
            # case2
            elif needle[i] != needle[j] and j > 0:
                j = lps[j - 1]
            # case3
            elif needle[i] != needle[j] and j == 0:
                lps[i] = 0
                i += 1
        return lps