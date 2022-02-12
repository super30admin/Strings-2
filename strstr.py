# Time Complexity : O(m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : yes

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle == "":
            return 0

        if len(needle) > len(haystack):
            return -1

        for i in range(len(haystack) - len(needle) + 1):
            j = 0

            while j < len(needle):
                lastIdx = i + len(needle) - 1
                if lastIdx < len(haystack) and haystack[lastIdx] != needle[-1]:
                    break
                elif haystack[i + j] != needle[j]:
                    break
                else:
                    j += 1
            if j == len(needle):
                return i

        return -1
