class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        if len(p)>len(s):
            return []
        
        d=Counter(p)
        
        result=[]
        match=0
        
        for j in range(len(s)):
            
            if s[j] in d:
                d[s[j]]-=1
                if d[s[j]]==0:
                    match+=1
                
            if j>=len(p):
                if s[j-len(p)] in d:
                    d[s[j-len(p)]]+=1
                    if d[s[j-len(p)]]==1:
                        match-=1
                        
            if match==len(d):
                result.append(j-len(p)+1)
                
        return result
            
                
                
                
                
            
                    
                