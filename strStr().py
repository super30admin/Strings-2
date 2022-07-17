# Time Complexity : O(m); m --> bigger array
# Space Complexity : O(n); n --> smaller array for maintaining lps array.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
class Solution:
    # finding lps array.
    def lps(self, needle):
        n = len(needle)
        lps = [0] * n
        j = 0
        i = 1
        while i < n:
            if needle[i] == needle[j]:
                j += 1
                lps[i] = j
                i += 1
            elif j > 0 and needle[i] != needle[j]:
                j = lps[j - 1]
            elif j == 0 and needle[i] != needle[j]:
                lps[i] = 0
                i += 1
        return lps

    def strStr(self, haystack: str, needle: str) -> int:
        m = len(haystack)
        n = len(needle)
        if m < n:
            return -1
        lps = self.lps(needle)  # recursive call.
        j = 0
        i = 0
        while i < m:
            if haystack[i] == needle[j]:
                j += 1
                i += 1
                if j == n:
                    return i - n
            else:
                if j == 0:
                    i += 1
                else:
                    j = lps[j - 1]
        return -1


print(Solution().strStr("aaaabaaaablah", "aaabaaaa"))

# Brute-Force
# O(n^2)
# class Solution:
#     def strStr(self, haystack: str, needle: str) -> int:
#         m = len(haystack)
#         n = len(needle)
#         starth = 0
#         temp = 0
#         startn = 0
#         while temp < m:
#             if haystack[temp] == needle[startn]:
#                 temp += 1
#                 startn += 1
#             else:
#                 starth += 1
#                 temp = starth
#                 startn = 0
#             if startn == n:
#                 return temp - startn
#         return -1
#
#
# print(Solution().strStr("aaaabaaaablah", "aaabaaaa"))
