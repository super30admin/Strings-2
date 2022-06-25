class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        hashmap={}
        match=0
        start=end=0
        output=[]
        for char in p:
            hashmap[char]=hashmap.get(char,0)+1
            
        while end<len(s):
            if s[end] in hashmap:
                hashmap[s[end]]-=1
                if hashmap[s[end]]==0:
                    match+=1
                    
            if end-start+1>len(p):
                if s[start] in hashmap:
                    hashmap[s[start]]+=1
                    if hashmap[s[start]]==1:
                        match-=1
                start+=1
            
                
            if match==len(hashmap):
                output.append(start)
            end+=1
        return output