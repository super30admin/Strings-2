# Time Complexity :O(n)
# Space Complexity :O(1)
# Leet Code: Yes

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        hashmap = {}
        n = len(p)
        res = []
        match = 0

        for char in p:
            if char not in hashmap:
                hashmap[char] = 1
            else:
                hashmap[char] += 1
        
        for i in range(len(s)):
            char = s[i]
            if char in hashmap:
                hashmap[char] -= 1
                if hashmap[char] == 0:
                    match += 1
            
            if i > len(p)-1:
                out = s[i-len(p)]
                if out in hashmap:
                    hashmap[out] += 1
                    if hashmap[out] == 1:
                        match -= 1
            if match == len(hashmap):
                res.append(i-len(p)+1)

        return res

            