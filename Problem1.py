'''
Time Complexity: O(n) where n is length of niddle
Space Complexity: O(n)
Run on Leetcode: YES
'''
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle) > len(haystack):
            return -1
        common = [0] * len(needle)
        j = 0
        i = 1
        while i < len(needle):
            if needle[j] == needle[i]:
                j += 1
                common[i] = j
                i += 1
            elif j > 0:
                j = common[j - 1]
            else:
                common[i] = 0
                i += 1

        i = 0
        j = 0
        while i < len(haystack):
            if haystack[i] == needle[j]:
                i += 1
                j += 1
                if j == len(needle):
                    return i - j
            elif j > 0:
                j = common[j-1]
            else:
                i += 1
        return -1