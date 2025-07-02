"""
Approach: for each start = (0-> n) check to ee if we can form a needle
t.c. => (h*n)
s.c. => O(1)
"""
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        h = len(haystack)
        n = len(needle)

        for start in range(h):
            flag = False
            for i in range(n):
                if start + i >= h or haystack[start + i] != needle[i]:
                    break
                if i == n - 1:
                    flag = True
            if flag:
                return start
        return -1