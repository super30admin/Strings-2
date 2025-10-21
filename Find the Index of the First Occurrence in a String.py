# Time Complexity : O(N + M) where N is the length of the string and M is the length of the needle
# Space Complexity : O(M) as we are LPS array of size M where M is length of needle
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using KMP algorithm to solve this problem.
# I am preprocessing the needle string to create the LPS (Longest Proper Prefix which is also Suffix) array.
# I am using the LPS array to avoid unnecessary comparisons when a mismatch occurs.
# I am iterating through the haystack string and comparing it with the needle string.
# If a match is found, I return the starting index of the match.
# If no match is found, I return -1.

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        #    using KMP algo
        n = len(needle)
        lps = [0] * n
        def preprocess(st):
            lps[0] = 0
            i = 1
            j = 0
            while i < n:
                if st[i] == st[j]:
                    j += 1
                    lps[i] = j
                    i += 1
                elif st[i] != st[j] and j > 0:
                    j = lps[j-1]
                else:
                    lps[i] = 0
                    i += 1
        preprocess(needle)
        i = 0 
        j = 0
        while i < len(haystack):
            if haystack[i] == needle[j]:
                i += 1
                j += 1
                if n == j:
                    return i - j
            elif haystack[i] != needle[j] and j > 0:
                j = lps[j-1]
            else:
                i += 1
        return -1





