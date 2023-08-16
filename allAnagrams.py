#TC - O(N)
#SC - O(k)
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        l = 0 
        match = 0 
        freq = {}
        res = []
        for i in p:
            if i not in freq:
                freq[i]=0
            freq[i]+=1
        for r in range(len(s)):
            if s[r] in freq:
                freq[s[r]]-=1
                if freq[s[r]]==0:
                    match+=1
            if match == len(freq):
                res.append(l)
            if (r-l+1)>len(p)-1:
                c = s[l]
                l+=1
                if c in freq:
                    if freq[c]==0:
                        match-=1
                    freq[c]+=1
        return res 