"""
time: O(N)
space: O(1)

"""

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(p) > len(s): return []
        pd = defaultdict(int)
        sd = defaultdict(int)
        res = []
        for i in range(len((p))):
            pd[p[i]] += 1
            sd[s[i]] += 1
            
        if pd == sd: 
            res = [0]

        l = 0
        
        for i in range(len(p),len(s)):
            
            sd[s[i]] += 1
            sd[s[l]] -= 1
            
            if sd[s[l]] == 0: 
                sd.pop(s[l])
            l += 1
            if sd == pd: 
                res.append(l)
            
        return(res)