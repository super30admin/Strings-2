#Time Complexity: O(n)
#Space Complexity: O(1)
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        dic = {}
        match = 0
        res = []
        for i in range(len(p)):
            if p[i] not in dic:
                dic[p[i]] = 1
            else:
                dic[p[i]] += 1
                
        
            
        for i in range(len(s)):
            ch = s[i]
            if ch in dic:
                dic[ch] -=1
                if dic[ch] == 0:
                    match += 1
                    
                    
            if i>=len(p):
                ch = s[i-len(p)]
                if ch in dic:
                    dic[ch] += 1
                    if dic[ch] == 1:
                        match -= 1
                        
            if match == len(p):
                res.append(i-len(p)+1)
                
        return res