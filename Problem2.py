# Time Complexity : O(m+n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


#save pattern in map and reduce the count if u find else increase
#if number of decrements is equal to length of map then a match occured
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        output = []
        
        if s == None or s == "" or p == None or p == "" or len(s) < len(p):
            return output
        
        pmap = {}
        
        for i in p:
            if i not in pmap:
                pmap[i] = 0
            pmap[i] += 1
        
        match = 0
        
        for i in range(len(s)):
            inc = s[i]
            
            if inc in pmap:
                count = pmap[inc]
                count -= 1
                if count == 0:
                    match += 1
                pmap[inc] = count
            
            if i >= len(p):
                out = s[i - len(p)]
                
                if out in pmap:
                    count = pmap[out]
                    count += 1
                    if count == 1:
                        match -= 1
                    pmap[out] = count
            
            if match == len(pmap):
                output.append(i-len(p) + 1)
                
        return output
                    
                
                
        
        