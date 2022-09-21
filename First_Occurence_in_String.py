'''
Time Complexity - O(m+n) 
Space Complexity - O(1)
'''


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m = len(haystack)
        n = len(needle)
        i = 0
        while (i <= m-n):
            j = 0
            if haystack[i] == needle[j]:
                k = i
                while(haystack[k] == needle[j]):
                    k += 1
                    j += 1
                    if j == n:
                        return i
            i += 1
        return -1
