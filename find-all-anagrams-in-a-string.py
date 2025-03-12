# Time O(n)
# Space O(26)
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        pmap = defaultdict(int)
        for c in p:
            pmap[c] += 1
        n = len(s)
        m = len(p)
        maplen = len(pmap)
        match = 0
        res = []
        # Slide window by 1 stride
        for i in range(n):
            # out
            if i >= m:
                if s[i-m] in pmap:
                    pmap[s[i-m]] += 1
                    if pmap[s[i-m]] == 1: match -= 1
            # in
            if s[i] in pmap:
                pmap[s[i]] -= 1
                if pmap[s[i]] == 0: match += 1
            
            if match == maplen:
                res.append(i - m + 1)
        return res




        