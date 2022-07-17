# Time Complexity : O(n)
# Space Complexity : O(1);
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
from collections import Counter


class Solution:
    def findAnagrams(self, s: str, p: str) -> list[int]:
        dictu = Counter(p)
        result = []
        match = 0
        for end in range(len(s)):
            if s[end] in dictu:
                dictu[s[end]] -= 1
                if dictu[s[end]] == 0:
                    match += 1
            if end >= len(p):
                if s[end-len(p)] in dictu:
                    dictu[s[end-len(p)]] += 1
                    if dictu[s[end-len(p)]] == 1:
                        match -= 1
            if match == len(dictu):
                result.append(end-len(p)+1)
        return result


print(Solution().findAnagrams('cbaaebabacd', 'caab'))


# prime-product pattern.
# class Solution:
#     def findAnagrams(self, s: str, p: str) -> list[int]:
#         dictup = {'a': 2, 'b': 3, 'c': 5, 'd': 7, 'e': 11, 'f': 13, 'g': 17, 'h': 19, 'i': 23, 'j': 29, 'k': 31, 'l': 37, 'm': 41, 'n': 43, 'o': 47, 'p': 53, 'q': 59, 'r': 61, 's': 67, 't': 71, 'u': 73, 'v': 79, 'w': 83, 'x': 89, 'y': 97, 'z': 101}
#         dictu = Counter(p)
#         result = []
#         product = 1
#         for i in dictu:
#             product *= dictup[i]
#         match = 1
#         for end in range(len(s)):
#             if s[end] in dictu:
#                 dictu[s[end]] -= 1
#                 if dictu[s[end]] == 0:
#                     match *= dictup[s[end]]
#             if end >= len(p):
#                 if s[end-len(p)] in dictu:
#                     dictu[s[end-len(p)]] += 1
#                     if dictu[s[end-len(p)]] == 1:
#                         match = match // dictup[s[end-len(p)]]
#             if match == product:
#                 result.append(end-len(p)+1)
#         return result
#
#
# print(Solution().findAnagrams('cbaaebabacd', 'caab'))
