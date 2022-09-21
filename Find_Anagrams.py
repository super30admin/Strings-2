'''
Time Complexity - O(m) where m is length of the string
Space Complexity - O(1)
'''


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        hmap = {}
        res = []
        match = 0
        for i in p:
            if i not in hmap:
                hmap[i] = 0
            hmap[i] += 1

        for i in range(len(s)):
            if s[i] in hmap:
                hmap[s[i]] -= 1
                if hmap[s[i]] == 0:
                    match += 1
            if i >= len(p):
                if s[i-len(p)] in hmap:
                    hmap[s[i-len(p)]] += 1
                    if hmap[s[i-len(p)]] == 1:
                        match -= 1
            if len(hmap) == match:
                res.append(i-len(p)+1)
        return res
