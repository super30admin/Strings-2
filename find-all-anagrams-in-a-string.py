# Time Complexity : O(m+n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes 
# Any problem you faced while coding this : No
from typing import List
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        result = []
        p_map = dict()
        for c in p:
            p_map[c] = p_map.get(c, 0)+1
        
        matchVal = 0
        for i in range(len(s)):
            inChar = s[i]
            if inChar in p_map:
                cnt = p_map[inChar]
                cnt-=1
                if cnt == 0:
                    matchVal+=1
                p_map[inChar] = cnt
            
            if (i >= len(p)):
                out = s[i-len(p)]
                if out in p_map:
                    cnt = p_map[out]
                    cnt+=1
                    if cnt == 1:
                        matchVal-=1
                    p_map[out] = cnt
            
            if matchVal == len(p_map):
                result.append(i-len(p)+1)
        
        return result