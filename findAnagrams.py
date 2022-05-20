# Time complexity -> O(m+n)
# Space complexity -> O(1)
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        res = []
        
        if not p or len(p) > len(s):
            return res
        
        hashMap = {}
        for i in p:
            hashMap[i] = hashMap.get(i,0) + 1 
            
        match = 0
        slow = 0
        
        for i in range(len(s)):
            
            if s[i] in hashMap:
                hashMap[s[i]] -= 1
                if hashMap[s[i]] == 0:
                    match += 1
                
            if i-slow  == len(p):
                if s[slow] in hashMap:
                    hashMap[s[slow]] += 1
                    if hashMap[s[slow]] == 1:
                        match -= 1
                slow += 1
                    
            if match == len(hashMap):
                res += [slow]
                                       
        return res