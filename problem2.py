#Time Complexity :O(n)
#Space Complexity :O(n)
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        h={}
        res=[]
        match=0
        
        #Traverse p and add element count to hashmap
        
        for i in p:
            if i not in h:
                h[i]=1
            else:
                h[i]+= 1
                
        #Traverse s if element present decrease the count and increase the match further applying sliding window approach
        
        for idx,k in enumerate(s):
            if k in h:
                h[k]-= 1
                if h[k] == 0:
                    match+= 1
                    
            if idx>=len(p):
                if s[idx-len(p)] in h:
                    if h[s[idx-len(p)]] == 0:
                        match-= 1
                    h[s[idx-len(p)]]+=1
                    
            if match == len(h):
                res.append(idx-len(p)+1)
                
        return res