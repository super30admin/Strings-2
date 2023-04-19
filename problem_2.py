# Time Complexity - O(M+N)
# Space Complexity - O(1)

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        n = len(s)
        m = len(p)
        count = 0
        res = []
        hashmap = {}

        for i in range(m):
            if p[i] in hashmap: 
                hashmap[p[i]] += 1
            else:
                hashmap[p[i]] = 1


        for i in range(n): 
            # in 
            if s[i] in hashmap: 
                hashmap[s[i]] -= 1
                if hashmap[s[i]] == 0: 
                    count += 1 

            # out
            if i >= m : 
                out = i-m 
                if s[out] in hashmap: 
                    hashmap[s[out]] += 1 
                    if hashmap[s[out]] == 1: 
                        count -= 1 
            if count == len(hashmap):
                res.append(i-m+1)

        return res
