#Time complexity: O(n)
#Space complexity: O(m)
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        res = []
        if len(p) > len(s):
            return res
        
        pMap = {}
        for char in p:
            if char not in pMap:
                pMap[char] = 0
            pMap[char] += 1
            
        match = 0
        
        for i in range(len(s)):
            inC = s[i]
            if inC in pMap:
                cnt = pMap[inC]
                cnt -= 1
                if cnt == 0:
                    match += 1
                pMap[inC] = cnt
            if i >= len(p):
                outC = s[i-len(p)]
                if outC in pMap:
                    cnt = pMap[outC]
                    cnt += 1
                    if cnt == 1:
                        match -= 1
                    pMap[outC]= cnt
            if match == len(pMap):
                res.append(i-len(p)+1)
        
        return res
                
            
            
        
            
        
