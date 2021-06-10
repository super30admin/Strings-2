"""Time Complexity: O(n)
Space Complexity: O(m), m -> len(hashmap)

Approach : sliding window"""
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        result = []
        match = 0
        if s is None and len(s)==0:
            return result
        hashmap = {}
        
        for i in range(len(p)):
            ch = p[i]
            if ch in hashmap:
                hashmap[ch]+=1
               
            else:
                hashmap[ch]=1

       
        
        for i in range(len(s)): #incoming
            ch = s[i]
            if ch in hashmap:
                count = hashmap[ch]
                count-=1
                hashmap[ch]=count
                if count==0:
                    match+=1
            #outgoing
            if i>=len(p):
                out = s[i-len(p)]
                if out in hashmap:
                    count = hashmap[out]
                    count+=1
                    hashmap[out]=count
                    if count==1:
                        match-=1
            if match == len(hashmap):
                result.append(i-len(p)+1)
        return result
        
                    