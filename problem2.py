#Time Complexity : O(n), where n is the length of the string s
#Space Complexity :O(min(m, n)), where n is the length of s and m is the length of p,
#Did this code successfully run on Leetcode : yes
from ast import List


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(p) > len(s) or len(p) == 0:
            return []

        p_hashmap, s_hashmap ={},{}

        for i in range(len(p)):
            p_hashmap[p[i]] = 1 + p_hashmap.get(p[i],0)
            s_hashmap[s[i]] = 1 + s_hashmap.get(s[i],0)
        
        res = []
        if p_hashmap == s_hashmap:
            res = [0]
        else:
            res = []  
        
        l = 0
        for r in range(len(p), len(s)):
            s_hashmap[s[r]] = 1 + s_hashmap.get(s[r],0)
            s_hashmap[s[l]] -= 1

            if s_hashmap[s[l]] == 0:
                del s_hashmap[s[l]]
            
            l += 1
            if s_hashmap ==  p_hashmap:
                res.append(l)
        
        return res


        