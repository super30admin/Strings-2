from collections import Counter
from typing import List
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        p_len=len(p)
        s_len=len(s)
        if p_len>s_len:
            return []
        p_map = Counter(p)
        s_map = Counter(s[:p_len])
        res=[]
        #check 1st if its a match
        if s_map==p_map:
            res.append(0)
        
        for i in range(p_len,s_len):
            #add incoming chr
            s_map[s[i]]+=1

            # remove outgoing char
            out = s[i - p_len]
            s_map[out] -= 1

            #before comparison, clean s_map of 0s
            if s_map[out]==0:
                del s_map[out]
            if s_map==p_map:
                res.append(i-p_len+1) #i is end index,out_idx= i-p_len, start_idx=i-p_len+1
                #eg: i =4 ie p_len, out_idx= 4-4=0, start_idx=4-4+1=1
        return res
