# T = O(m+n)
# S = O(1)

# Approach:
# Create a hash map of the p string. traverse through the s string and for every tile the 
# count becomes zero for all the keys in the map record the index.

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if not s or len(s) < len(p):
            return []
        res = []
        Map = {}
        match = 0
        l = len(p)
        for i in p:
            if i in Map:
                Map[i] += 1
            else:
                Map[i] = 1
                
        for i in range(len(s)):
            c = s[i]
            if c in Map:
                Map[c] -= 1
                if Map[c] == 0:
                    match += 1
            if i >= l:
                out = s[i-l]
                if out in Map:
                    Map[out] += 1
                    if Map[out] == 1:
                        match -= 1
            if match == len(Map):
                res.append(i-l+1)
        return res