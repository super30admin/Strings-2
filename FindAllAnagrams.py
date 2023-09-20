#Time Complexity: O(n)
#Space Complexity: O(1)

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(s)<len(p):
            return []
        res = []
        matches = 0
        m = len(s)
        n = len(p)
        d = {}
        for i in p:
            d[i] = 1+d.get(i,0)
        for i in range(m):
            if s[i] in d:
                d[s[i]]-=1
                if d[s[i]]==0:
                    matches+=1
            if i>=n:
                if s[i-n] in d:
                    d[s[i-n]]+=1
                    if d[s[i-n]]==1:
                        matches-=1
            if matches == len(d):
                res.append(i+1-n)
        return res
        