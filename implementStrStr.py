#Time Complexity : O(n+m) where n is the length of the haystack and m is the length of the needle
#Space Complexity : O(m) where m is the length of the needle
#Did this code successfully run on Leetcode : Yes

#OPTIMIZEED
class Solution:
    def getLPS(self, needle):
        lps = [0] * len(needle)
        i, j = 1, 0
        while i < len(needle):
            #case 1: if both chars are equal
            if needle[i] == needle[j]:
                j += 1
                lps[i] = j
                i += 1
            #case 2: if both chars are not equal and j is not at index 0 yet then decrease size of substring to check if prefix and sufix are equal
            elif j > 0 and needle[i] != needle[j]:
                j = lps[j-1]
            #case 3: if both chars are not equal and j has reached the 0th index then we have foung that there is no prefix and sufix which match
            elif j == 0 and needle[i] != needle[j]:
                lps[i] = 0
                i += 1
        return lps

    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle) == 0:
            return 0
        m, n = len(haystack), len(needle)
        #get longest prefix sufix of needle
        lps = self.getLPS(needle)
        if m < n:
            return -1
        j, i = 0, 0
        #iterate through haystack to find pattern
        while i < m:
            if haystack[i] == needle[j]:
                j += 1
                i += 1
                if j == n:
                    return i - n
            elif j > 0 and haystack[i] != needle[j]:
                j = lps[j-1]
            elif j == 0 and haystack[i] != needle[j]:
                i += 1
        return -1

# class Solution:
#     def strStr(self, haystack: str, needle: str) -> int:
#         #handle edge cases
#         if (not needle and not haystack) or (haystack and not needle):
#             return 0
#         n = len(needle)
#
#         for i in range(len(haystack)-n+1):
#             #check if first letter of needle is equal to curr char in haystack, if so check if substring of haystack is equal to the needle
#             if haystack[i] == needle[0] and haystack[i:i+n] == needle:
#                 return i

#        return -1
