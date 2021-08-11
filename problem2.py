class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if (len(p)>len(s)):
            return []
        result=[]
        match=0
        pstore=dict()
        for v in  p:
            if v not in pstore:
                pstore[v]=0
            pstore[v]+=1
        n=len(p)  
        
        for i in range(len(s)):
            
            #In logic
            if s[i] in pstore:
                pstore[s[i]]-=1
               
                if pstore[s[i]]==0:
                    
                    match+=1
            #out from window logic
            if i>=len(p):
                
                if s[i-len(p)] in pstore:
                    
                    pstore[s[i-len(p)]]+=1
                    if pstore[s[i-len(p)]]==1:
                        match-=1
            
            if match==len(pstore):
                result.append(i-n+1)
        return result
    #Time O(n+m)
    #Space O(m),p len is m
