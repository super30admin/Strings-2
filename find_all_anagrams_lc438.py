"""
Author: Srindihi Bhat
Did it run on LC: Yes
Time Complexity: O(len(s)+len(T)) - Iterating through both the strings
Space Complexity: O(len(S)+len(T)) - Hashmaps for inputs

Idea - Have 2 hashmaps - one to know S's count and one to know P count
when sHashmap == pHashmap, we note the output list
"""
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        lenS, lenP = len(s), len(p)
        
        #not possible to find the string in smaller search space
        if lenS < lenP:
            return []
        
        p_map ={} 
        s_map = {}
        
        for char in p:
            p_map[char] = p_map.get(char,0)+1
        
        output = []
        
        #Creating sliding window
        for i in range(lenS):
            #adding freq to S hashmap
            s_map[s[i]] = s_map.get(s[i],0)+1
            
            if i >=lenP:
                if s_map[s[i-lenP]] == 1:
                    #need to delete because the window has slided
                    del s_map[s[i-lenP]] 
                else:
                    s_map[s[i-lenP]]-=1
            
            if p_map == s_map:
                #need to append the start position
                #new_start = current_pos - len(P) + 1
                #this is because starting pos will be current_pos - len(P)
                output.append(i - lenP+1)
        return output