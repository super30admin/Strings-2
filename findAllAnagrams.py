# Time Complexity : O(M+n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nope


# Your code here along with comments explaining your approach

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        res = []
        hm = defaultdict()
        
        for i in range(len(p)):
            if p[i] not in hm:
                hm[p[i]] = 1
            else:
                hm[p[i]] += 1
                
        match = 0 
        for i in range(len(s)):
            charIn = s[i]
            if charIn in hm:
                count = hm[charIn]
                count -= 1
                if count == 0:
                    match += 1
                hm[charIn] = count
                
            if i >= len(p):
                charOut = s[i-len(p)]
                if charOut in hm:
                    count = hm[charOut]
                    count += 1
                    if count == 1:
                        match -= 1
                    hm[charOut] = count 
            if match == len(hm):
                res.append(i - len(p) + 1)
                
        return res