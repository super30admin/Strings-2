# TC: O(N) since we are iterating over all the characters of the string once. 
# SC: O(1) since we are using a hashmap of character array which is constant space of 26 characters.

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if not s or len(s) == 0: 
            return []
        
        hmap = {}
        
        for i in p: 
            hmap[i] = hmap.get(i, 0) + 1
        
        
        result = []
        match = 0
        for i in range(len(s)): 
#             incoming character
            inc = s[i]
            if inc in hmap.keys(): 
                count = hmap[s[i]]
                count -= 1
                hmap[s[i]] = count
                if count == 0: 
                    match += 1
            
#             outgoing character
            if i >= len(p):
                ogc = s[i - len(p)]
                if ogc in hmap.keys(): 
                    count_ogc = hmap.get(ogc) 
                    count_ogc += 1
                    hmap[ogc] = count_ogc
                    if count_ogc == 1: 
                        match -= 1
            
            if match == len(hmap):
                result.append((i - len(p)) + 1)
        
        return result
