class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle in haystack:
            for i in range(len(haystack)-len(needle)+1):
                if haystack[i:(len(needle)+i)]==needle:
                    return i
        else:
            return -1
#Time-complexity:O((N-L)L)
#Space-complexity:O(1)