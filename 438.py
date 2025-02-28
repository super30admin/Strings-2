# TC : O(m +n)
# SC = O(1)----- only limites letters 26
from collections import defaultdict


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(s) == 0 or len(p) == 0 or len(p) > len(s):
            return []
        result = []
        map1 = defaultdict(int)
        matches = 0
        for i in range(len(p)):
            map1[p[i]] += 1
        for k  in range(len(s)):
            if s[k] in map1:
                map1[s[k]] -= 1 # incoming 
                if map1[s[k]] == 0:
                    matches += 1  

            if k >= len(p):
                outgoing = s[k- len(p)]
                if outgoing in map1:
                    map1[outgoing] += 1
                    if map1[outgoing] == 1:
                        matches = matches -1
            if matches == len(map1):
                result.append(k - len(p) +1)
        
        return result
        
        

        