# TC : O(n)
# SC : O(1)
from collections import Counter
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        l_s = len(s)
        l_p = len(p)
        if l_p > l_s:
            return []
        res = []
        pc = Counter(p)
        tc = Counter()
        # print(pc)
        for i in range(l_s):
            tc[s[i]] += 1
            if i>=l_p:
                if tc[s[i-l_p]]==1:
                    del tc[s[i-l_p]]
                else:
                    tc[s[i-l_p]] -= 1
            if tc==pc:
                res.append(i - l_p + 1)
            # print(i, s[i:i+l_p], tc)
        return res