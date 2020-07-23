"""
// Time Complexity : o(max(m,n)), m -> length of s, n-> length of p
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""

from collections import defaultdict

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        d = defaultdict(int) #for frequency of chars in p
        
        for i in p:
            d[i] += 1
            
        match = 0 #keeps track of matched characters
        res = []
        
        for j in range(len(s)):
            #incoming char
            if s[j] in d: #if current char in d, reduce its count
                d[s[j]] -= 1
                
                if d[s[j]] == 0: #if count becomes 0, char matched
                    match += 1
                
            if j >= len(p): #outgoing char
                out = s[j - len(p)] #leftmost char in string window
                if out in d: #increase the count for char removed
                    d[out] += 1
                    
                    if d[out] == 1:
                        match -= 1
                     
            if match == len(d): #if match equals length of dictionary, add to result
                res.append( j - len(p) + 1)
                
        return res
            
        
        