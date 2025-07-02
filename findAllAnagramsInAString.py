"""
approach: maintain a sliding window over s string. if the current window count == the pcount (i.e. the count
of p string) then its a anagram of p in s and add to start of window result
t.c. = O(p + s)
s.c. = O(1)
"""
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        windowCount = [0 for i in range(26)]
        pCount = [0 for i in range(26)]
        plen = len(p)

        for c in p:
            idx = ord(c) - ord('a')
            pCount[idx] += 1

        l = 0
        res = []
        for r in range(len(s)):
            idx = ord(s[r]) - ord('a')
            windowCount[idx] += 1

            if r - l + 1 > plen:
                idx = ord(s[l]) - ord('a')
                windowCount[idx] -= 1
                l += 1

            if r - l + 1 == plen and tuple(windowCount) == tuple(pCount):
                res.append(l)
        return res