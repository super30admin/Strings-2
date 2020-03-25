'''
Time Complexity: O(n-l)l
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation:
'''


def strStr(self, haystack: str, needle: str) -> int:
    L, n = len(needle), len(haystack)


    for start in range(n - L + 1):
        if haystack[start: start + L] == needle:
            return start
    return -1
