# Leetcode: https://leetcode.com/problems/implement-strstr/

# Approach 1: Substring: Linear Time Slice,
#     move sliding window along the string and compare substring in the window with the needle.
#
# Time Complexity: O((m-n)*n), where m is length of haystack, n is length of needle
# Space Complexity: O(1)

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        ln = len(needle)
        lhs = len(haystack)

        for start in range(lhs - ln + 1):
            if haystack[start: start + ln] == needle:
                return start

        # if needle is not found
        return -1


# Approach 2: Two Pointers: Linear Time Slice
# 1. Move pn till you'll find the first character of the needle string in the haystack.
# 2. Compute the max string match by increasing pn, pL and curr_len in the case of equal characters.
# 3. If you managed to get the full match, curr_len == L, return the start position of that match, pn - L.
# 4. If you didn't, backtrack: pn = pn - curr_len + 1, pL = 0, curr_len = 0.
#
# Time Complexity: O((m-n)*n), where m is length of haystack, n is length of needle,
#     in the worst case of complete false matches and O(m) in the best case
# Space Complexity: O(1)

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:

        if len(needle) is 0:
            return 0

        if len(haystack) < len(needle):
            return -1

        i = 0 # pointer in haystack

        while i < len(haystack) - len(needle) + 1:
            # find the position of first needle character in the haystack string
            while i < len(haystack) - len(needle) + 1 and haystack[i] != needle[0]:
                i += 1

            # compute the max match string
            curr_len = 0
            j = 0 # pointer in needle
            while i < len(haystack) and j < len(needle) and haystack[i] == needle[j]:
                i += 1
                j += 1
                curr_len += 1

            # if the whole needle string is found, return its start position
            if curr_len == len(needle):
                return i - len(needle)

            # otherwise backtrack
            i = i - curr_len + 1

        return -1


# Approach 3: Knuth–Morris–Pratt algorithm
# KMP algorithm focuses on finding repeated prefix and suffix and their index to avoid
# starting the match from index 0 everytime. Hence we create an LPS (longest prefix suffix)
# array of the index of prefix and suffix matching index for needle and accordingly traverse the haystack.
#
# Time Complexity: O(m+n) where m is soze of needle and n is size of haystack
# Space Complexity: O(n) for LPS

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle) == 0:
            return 0
        if len(haystack) < len(needle):
            return -1
        LPS = self.calculateLPS(needle)
        i = 0
        j = 0

        while i < len(haystack):
            # case 1
            if haystack[i] == needle[j]:
                i += 1
                j += 1
                # case 2
                if j == len(needle):
                    return i - j
            # case 3
            else:
                if j == 0:
                    i += 1
                else:
                    j = LPS[j - 1]
        return -1

    def calculateLPS(self, needle):
        LPS = [0] * len(needle)

        j = 0
        i = 1

        while i < len(needle):
            # case 1
            if needle[i] == needle[j]:
                j += 1
                LPS[i] = j
                i += 1
            # case 2
            elif j > 0 and needle[i] != needle[j]:
                j = LPS[j - 1]
            # case 3
            elif j == 0 and needle[i] != needle[j]:
                LPS[i] = 0
                i += 1
        return LPS