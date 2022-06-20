'''
Using Sliding Window Approach
Time: O(n)
Space: O(1)
'''

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        result = list()
        
        if len(p) > len(s):
            return result
        
        hm = dict()
        
        for ch in p:
            if ch not in hm:
                hm[ch] = 1
            else:
                hm[ch] += 1
        
        match = 0
        for i in range(len(s)):
            
            inc = s[i]
            if inc in hm:
                hm[inc] -= 1
                if hm[inc] == 0:
                    match += 1
            
            if i >= len(p):
                out = s[i - len(p)]
                if out in hm:
                    hm[out] += 1
                    if hm[out] == 1:
                        match -= 1
            
            if match == len(hm):
                result.append(i-len(p)+1)
        
        return result
        