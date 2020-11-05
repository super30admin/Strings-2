# TC: O(N+M)
# SC: O(N+M)
# Don't know how to solve it

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        hmap_s = {}
        hmap_p = {}
        for i in s:
            hmap_s[i] = hmap_s.get(i,0) + 1
        print(hmap_s)
        
        for i in p:
            hmap_p[i] = hmap_p.get(i,0) + 1
        print(hmap_p)
        
        while i in range(len(s)):
            if i in hmap_p:
                hmap_p[i] -= 1
            