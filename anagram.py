# // Time Complexity :O(m+n), length of string and pattern
# // Space Complexity :O(1),character array
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach




class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        hmap={}
        match=0
        result=[]
        for i in range(len(p)):
            if p[i] not in hmap.keys():
                hmap[p[i]]=0
            hmap[p[i]]+=1
        for i in range(len(s)):#i is fast pointer, i-len(pattern)=>slow pntr
            #incoming
            if s[i] in hmap.keys():
                    hmap[s[i]]-=1
                    if hmap[s[i]]==0:
                        match=match+1
                    
            #outgoing
            if i >= len(p):
                
                if s[i-len(p)] in hmap.keys():
                    
                    hmap[s[i-len(p)]]+=1
                    if hmap[s[i-len(p)]]==1:
                        match-=1
        
            if match==len(hmap):
            
                
                result.append(i-len(p)+1)
            
        return result
                        
                
            
                
            
        