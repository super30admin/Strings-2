class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        m=len(s)
        n=len(p)
        smap={}
        result=[]

        for i in range(n):
            c=p[i]
            if c in smap:
                smap[c]+=1
            else:
                smap[c]=1
        match=0
        
        for i in range(m):
            c=s[i]
            if c in smap:
                frq=smap[c]
                frq-=1
                smap[c]=frq
                if frq==0:
                    match+=1
            if i>=n:
                c=s[i-n]
                if c in smap:
                    frq=smap[c]
                    frq+=1
                    smap[c]=frq
                    if frq==1:
                        match-=1
            if match==len(smap):
                result.append(i-n+1)
        return result
        