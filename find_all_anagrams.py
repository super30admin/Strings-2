"""
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
"""

class Solution:
    def findAnagrams(self, s, p):
        result = []
        if len(s) == 0 or not s or len(p) > len(s):
            return result
        
        hashmap = {}
        match = 0
        
        for j in p:
            if j not in hashmap:
                hashmap[j] = 0
            hashmap[j] += 1
                 
        for i in range(len(s)):
            in_char = s[i]
            if in_char in hashmap:
                hashmap[in_char] -= 1
                if hashmap[in_char] == 0:
                    match += 1
            
            if i >= len(p):
                out_char = s[i - len(p)]
                if out_char in hashmap:
                    hashmap[out_char] += 1
                    if hashmap[out_char] == 1:
                        match -= 1
            
            if match == len(hashmap):
                result.append(i - len(p) + 1)
                
        return result
    
s = Solution()
print(s.findAnagrams("baa", "aa"))