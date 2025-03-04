'''
    Time Complexity: O(mn)
    Space Complexity: O(1)
'''
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        n = len(haystack)
        m = len(needle)

        for i in range(n - m + 1):
            for j in range(m):
                if haystack[i+j] != needle[j]:
                    break
                elif j == m-1:
                    return i

        return -1