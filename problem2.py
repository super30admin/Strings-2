'''
BruteForce:
Time Complexity: O(n-l)l
Space Complexity: O(1)

Effecient:
Time Complexity: O(m+n) m -> length of needle, n->length of haystack
Space Complexity: O(m)
Did this code successfully run on Leetcode : Yes
Explanation: Using KMP Algorithim
'''


class Solution:
    def computePI(self, pattern):
        n = len(pattern)

        pi = [0] * n

        j = 0
        i = 1

        while i < n:
            if pattern[i] == pattern[j]:
                j += 1
                pi[i] = j
                i += 1
            else:
                if j == 0:
                    pi[i] = 0
                    i += 1
                else:
                    j = pi[j - 1]

        return pi

    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle) == 0:
            return 0

        pi = self.computePI(needle)

        i = j = 0

        while i < len(haystack):
            if haystack[i] == needle[j]:
                i += 1
                j += 1

                if j == len(needle):
                    return i - j
            else:
                if j == 0:
                    i += 1
                else:
                    j = pi[j - 1]
        return -1



def BruteForcestrStr(self, haystack: str, needle: str) -> int:
    L, n = len(needle), len(haystack)


    for start in range(n - L + 1):
        if haystack[start: start + L] == needle:
            return start
    return -1
