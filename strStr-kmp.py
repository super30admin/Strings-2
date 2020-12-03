# Time Complexity: O(m+n)
# Space Complexity: O(n) for the LPS array

class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        if not needle: return 0
        return KMP(haystack, needle)

# Compute the pi table or LPS table for the pattern
def computeLPS(pattern):
    lps = [0 for c in pattern]
    index = 0
    i = 1
    while i < len(lps):
        if pattern[i] == pattern[index]:
            lps[i] = index + 1
            index += 1
            i += 1
        else:
            if index != 0:
                index = lps[index-1]
            else:
                lps[i] = 0
                i += 1
    return lps


# KMP Algorithm
def KMP(text, pattern):
    lps = computeLPS(pattern)
    i, j = 0, 0
    indices = []
    while i < len(text) and j < len(pattern):
        if text[i] == pattern[j]:
            i += 1
            j += 1
            if j == len(pattern):
                indices.append(i-j)
                # print("Pattern found at index " + str(i-j))
                j = lps[j-1]
        else:
            if j != 0:
                j = lps[j-1]
            else:
                i += 1
    if indices:
        return indices[0]
    return -1