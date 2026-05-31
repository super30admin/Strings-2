from typing import Counter


class Solution:
    def findAnagrams(self, s, p):
        ls, lp = len(s), len(p)
        pmap = Counter(p)
        result = []
        matched = 0
        for i in range(ls):
            incoming = s[i]
            if incoming in pmap:
                pmap[incoming] -= 1
                if pmap[incoming] == 0:
                    matched += 1

            if i >= lp:
                outgoing = s[i - lp]
                if outgoing in pmap:
                    pmap[outgoing] += 1
                    if pmap[outgoing] == 1:
                        matched -= 1

            if matched == len(pmap):
                result.append(i - lp + 1)

        return result
