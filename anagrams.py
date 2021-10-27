#Time Complexity : O(n)
#Space Complexity : O(m) 
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No




class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        res = []
        start = 0
        end = 0
        match = 0
        h = {}
        for i in p:
            h.setdefault(i, 0)
            h[i] += 1
            
        while end < len(s):
            #incoming
            inc = s[end]
            if inc in h.keys():
                h[inc] -= 1
                if h[inc] == 0:
                    match += 1
            #outgoing
            if end - start == len(p):
                out = s[start]
                if out in h.keys():
                    h[out] += 1
                    if h[out] == 1:
                        match -= 1
                start += 1
            if match == len(h):
                res.append(start)
            end += 1
        return res