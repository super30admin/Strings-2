class Solution:
    # sliding window
    # TC : O(m+n)
    # SC : O(1)
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if s is None or len(s) == 0 or len(p) > len(s):
            return []
        matchval = 0
        hmap = defaultdict(int)
        res = []
        for ch in p:
            hmap[ch] += 1
        # slide over s
        for i in range(len(s)):
            incoming = s[i]
            if incoming in hmap.keys():
                ct = hmap[incoming]
                ct -= 1
                if ct== 0:
                    matchval += 1
                hmap[incoming] = ct
            if i >=len(p):
                outgoing = s[i-len(p)]
                if outgoing in hmap.keys():
                    ct = hmap[outgoing]
                    ct += 1
                    if ct == 1:
                        matchval -= 1
                    hmap[outgoing] = ct
            if matchval == len(hmap):
                res.append(i-len(p)+1)

        return res
        