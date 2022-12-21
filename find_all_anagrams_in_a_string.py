class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        hm = collections.Counter(p)
        match = 0
        size = len(hm)

        res = []

        for i in range(len(s)):
            if s[i] in hm.keys():
                hm[s[i]] -= 1
                if hm[s[i]] == 0:
                    match += 1
            
            if i >= len(p):
                if s[i-len(p)] in hm.keys():
                    hm[s[i-len(p)]] += 1
                    if hm[s[i-len(p)]] == 1:
                        match -= 1
            
            if match == size:
                res.append(i - len(p) + 1)
        
        return res