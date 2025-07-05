#Anagrams
#TC: O(m+n)
#SC :O(1)
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        freq_map = {}
        for pi in p:
            if pi in freq_map:
                freq_map[pi] +=1
            else:
                freq_map[pi] = 1
        
        length = 0
        map_length = len(freq_map)
        result =[]
        for si in range(0, len(s)):
            #incoming
            if s[si] in freq_map:
                freq_map[s[si]] -= 1
                if freq_map[s[si]] == 0:
                    length +=1
                    
            #outgoing
            oi = si - len(p)
            if oi >=0:
                if s[oi] in freq_map:
                    freq_map[s[oi]] = freq_map [s[oi]] + 1
                    if freq_map[s[oi]] == 1:
                        length -=1
            
            if length == map_length:
                result.append(si-len(p)+1)

        return result