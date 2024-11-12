#Time Complexity: O(n)
#Space Complexity: O(1) considering constant space for the alphabet size of 26.
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        res = []
        if(len(p)>len(s)):
            return res
        scount = dict()
        pcount = dict()
        for i in range(0, len(p)):
            pcount[p[i]]=pcount.get(p[i],0)+1
            scount[s[i]]=scount.get(s[i],0)+1
        if(pcount==scount):
            res = [0]
        else:
            res = [] 
        l = 0
        for r in range(len(p), len(s)):
            scount[s[r]]=scount.get(s[r],0)+1
            scount[s[l]]-=1
            if(scount[s[l]]==0):
                scount.pop(s[l])
            l+=1
            if(scount==pcount):
                res.append(l)
        return res

        
            
        



        