# 438. Find All Anagrams in a String

# Time Complexity: O(n); size of the str 
# Space Complexity: O(m); size of the substring to be found
# Did this code successfully run on Leetcode: all test cases passed
# Any problem you faced while coding this: No

# Approach: Sliding Window Approach

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        if not p or len(p) == 0:
            return []
        
        if len(p) > len(s):
            return []
        
        # add all the letters of p in a hashmap
        result = []
        map_str_p = {}
        
        for char in list(p):
            map_str_p[char] = map_str_p.get(char, 0) + 1
        
        # Sliding Window Approach
        
        i = 0
        match = 0
        while(i<len(s)):
            
            # incoming character
            
            if s[i] in map_str_p:
                map_str_p[s[i]] = map_str_p[s[i]] - 1
                
                if map_str_p[s[i]] == 0:
                    match = match+1
            
            # outgoing character
            
            if i >= len(p):
                
                out = i-len(p)
                if s[out] in map_str_p:
                    map_str_p[s[out]] = map_str_p[s[out]] + 1
                
                    if map_str_p[s[out]] == 1:
                        match = match-1

            if match == len(map_str_p):
                result.append(i-len(p)+1)
            i+=1
        return result  
