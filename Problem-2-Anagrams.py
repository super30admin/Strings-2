#Time complexity:O(N+M), N=len(s) and M=len(p)
#Space complexity:O(M), M=len(p)
class Solution:
    def findAnagrams(self, s, p) :
        result = []
        if s == None or len(s) == 0 or len(p) > len(s):
            return result
        hmap = {}

        for ch in p:
            if ch in hmap:
                hmap[ch] += 1
            else:
                hmap[ch] = 1

        match = 0
        n = len(p)

        for i in range(0, len(s)):
            ch = s[i]
            # in
            if ch in hmap:
                hmap[ch] -= 1
                if hmap[ch] == 0:
                    match += 1
            # out
            if i >= n:
                out = s[i - n]
                if out in hmap:
                    hmap[out] += 1
                    if hmap[out] == 1:
                        match -= 1

            if match == len(hmap.keys()):
                result.append(i - n + 1)
        return result

