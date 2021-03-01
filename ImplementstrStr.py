# Time Complexity : O(M+N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using KMP Longest Common Prefix Suffix
# First we need to get the lps on needle string
# Once we got the lps then we need to iterate on main string haystack where i = 0 and j = 0 in needle string
# If the character at i and character at j are equal then we increment i by 1 and j by 1 and if j reaches the end then return i - len(needle) that is j
# If the characters are not equal and j > 0 then j = lps[j-1]
# If the characters are not equal and  j == 0 then increment i by 1
# If no match is found return -1


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if not needle:
            return 0
        lps = self.longestCommonPrefixSuffix(needle)
        i = 0
        j = 0
        while i < len(haystack):
            #case1
            if needle[j] == haystack[i]:
                i += 1
                j += 1
                if j == len(needle):
                    return i - j
            #case2
            elif needle[j] != haystack[i] and j > 0:
                j = lps[j - 1]
            #case3
            elif needle[j] != haystack[i] and j == 0:
                i += 1
        return -1

    def longestCommonPrefixSuffix(self, needle):
        lps = [0] * len(needle)
        i = 1
        j = 0
        while i < len(needle):
            #case1
            if needle[j] == needle[i]:
                j += 1
                lps[i] = j
                i += 1
            #case2
            elif needle[j] != needle[i] and j > 0:
                j = lps[j - 1]
            #case3
            elif needle[j] != needle[i] and j == 0:
                i += 1
        return lps