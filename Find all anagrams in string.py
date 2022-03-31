# Time Complexity = O(s)
# Space Complexity = O(k) atmost 26 characters, considered as O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findAnagrams(self, s, p):
        
        if len(p) > len(s): return []
        
        # Hashmap to track count
        sc, pc = {}, {}
        
        # loop for first three characters
        for i in range(len(p)):
            sc[s[i]] = 1 + sc.get(s[i], 0)
            pc[p[i]] = 1 + pc.get(p[i], 0)
        
        # if anagram found start the list with 0(start Index) or empty list
        res = [0] if pc == sc else []
        l = 0 # left pointer
        
        # loop for right pointer
        for r in range(len(p), len(s)):
            sc[s[r]] = 1 + sc.get(s[r], 0)
            sc[s[l]] -= 1
            
            # pop the left pointer element for each iteration and increment index
            if sc[s[l]] == 0:
                sc.pop(s[l])    
            l += 1
            
            # append to list if both hashmap are equal
            if sc == pc: res.append(l)
        
        return res