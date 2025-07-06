# TC: O(m+n)
# SC: O(1)
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        res=[]
        hmap=Counter(p)
        m=0
        for i in range(len(s)):
            c=s[i]
            if c in hmap:
                cnt=hmap[c]
                cnt-=1
                hmap[c]=cnt
                if cnt==0:
                    m+=1
            
            if i>=len(p):
                if s[i-len(p)] in hmap:
                    cnt=hmap[s[i-len(p)]]
                    cnt+=1
                    hmap[s[i-len(p)]]=cnt
                    if cnt==1:
                        m-=1
            
            if m==len(hmap):
                res.append(i-len(p)+1)
            
        
        return res
                    

            
            