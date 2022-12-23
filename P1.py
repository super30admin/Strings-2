# TC : O(n)
# SC : O(1)
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        k = len(needle)
        # curr = haystack
        for i in range(len(haystack) - k + 1):
            # print(i, haystack[i], haystack[i:i+k], needle)
            if haystack[i:i+k]==needle:
                return i
        return -1
            