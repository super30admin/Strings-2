"""
TC: O(N)/O(1)
"""
from collections import Counter
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        hash_sum = 0
        for k in p:
            hash_sum += hash(k)    
        cnt = 0
        res = []
        
        for i in range(len(s)):
            cnt += hash(s[i])
            
            if i >= len(p):
                cnt -= hash(s[i-len(p)])
            
            if cnt == hash_sum :
                res.append(i-len(p)+1) 
            
        return res
            
