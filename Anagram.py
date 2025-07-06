# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if s == None or p == None or len(s) == 0 or len(p) == 0:
            return []
        
        result = []
        m = len(p)
        n = len(s)
        hmap = defaultdict(int)
        # Iterate through the p string
        for i in range(m):
            hmap[p[i]] += 1
        matches = 0
        # Iterate through the s string
        for i in range(n):
            
            # Incoming Character
            in_char = s[i]
            if in_char in hmap:
                hmap[in_char] -= 1
                if hmap[in_char] == 0:
                    matches += 1

            # Outgoing Character
            if i>=m:
                out_char = s[i-m]
                if out_char in hmap:
                    hmap[out_char] += 1
                    if hmap[out_char] == 1:
                        matches -= 1 
                    
            
            if matches == len(hmap):
                result.append(i-m+1)
        return result