# Runs on Leetcode
    # m is length of s and n is length of p
      # Runtime - O(m+n)
      # Space - O(n) 
      

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if not s or not p:
            return []
        match = 0
        d = {}
        result = []
        for i in p:
            if i not in d:
                d[i] = 1
            else:
                d[i] += 1
        for i in range(len(s)):
            if s[i] in d:
                d[s[i]] -= 1
                if d[s[i]] == 0:
                    match += 1
            
            if i >= len(p):
                if s[i-len(p)] in d:
                    d[s[i-len(p)]] += 1
                    if d[s[i-len(p)]] >= 1:
                        match -= 1
                        if match == len(p):
                            result.append(i-len(p)+1)
                            
            if match == len(d):
                result.append(i-len(p)+1)
                
        return result
