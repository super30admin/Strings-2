class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        # SC o(1) => no of alphabet(m) = 26 => constant
        # TC O(m + n)
        result  = []
        if p is None or len(p) == 0 or s is None or len(s) == 0:
            return result
        maps ={}
        for i in p:
            if i in maps:
                maps[i] = maps[i] + 1
            else:
                maps[i] = 1
        match = 0
        for i in range (len(s)):
            # if incoming character is present in dict
            ins = s[i]
            if ins in maps:
                cnt = maps[ins]
                cnt -=1
                if cnt == 0:
                    match += 1
                # Update dictionary
                maps[ins] = cnt
            
            # Outgoing character
            if i >= len(p):
                out = s[i - len(p)]
                if out in maps:
                    cnt  = maps[out]
                    
                    # If outgoing ch exist in map, increase the count
                    cnt +=1
                    if cnt == 1:
                        match -=1
                        
                    # Update dictionary
                    maps[out] = cnt
            
            if match == len(maps):
                asn = i - len(p) + 1
                result.append(asn)
        return result
                    
                    
