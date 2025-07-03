from collections import Counter
from typing import List
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        charc = Counter(p)
        m,n,matchc , res= len(p), len(s), 0, []
        for i in range(n):
            inc = s[i]
            if inc in charc:
                charc[inc] -= 1
                if charc[inc] == 0:
                    matchc+=1
            if i>=m:
                outc = s[i-m]
                if outc in charc:
                    cnto = charc[outc]
                    cnto+=1
                    charc[outc] = cnto
                    if cnto == 1:
                        matchc-=1
            if matchc == len(charc):
                res.append(i-m+1)
        return res
        