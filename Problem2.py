'''
Time Complexity: O(m + n) where m is length of s and n is length of p
Space Complexity: O(n)
Run on Leetcode: YES
'''
class Solution:
    def findAnagrams(self, s: str, p: str) -> list[int]:
        if len(p) > len(s):
            return []
        cMap = {}
        result = []
        for ch in p:
            if not ch in cMap:
                cMap[ch] = 0
            cMap[ch] += 1
        slow = 0
        match = 0
        for i in range(len(s)):
            if s[i] in cMap:
                cMap[s[i]] -= 1
                if cMap[s[i]] == 0:
                    match += 1
            if i >= len(p):
                if s[i - len(p)] in cMap:
                    cMap[s[i - len(p)]] += 1
                    if cMap[s[i - len(p)]] == 1:
                        match -= 1
            if match == len(cMap):
                result.append(i - len(p) + 1)
        return result