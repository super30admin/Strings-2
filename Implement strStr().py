# TC: O(N*(H-N)), N = len(needle), H = len(haystack)
# SC: O(1)
# Yes, it ran on leetcode
# Problems: I don't know how to optimize it, I tried 2 pointers but not able think it off

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        l1, l2 = len(haystack), len(needle)
        for i in range(l1 - l2 + 1):
            if needle == haystack[i:i+l2]:
                return i
        return -1