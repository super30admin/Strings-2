# Time Complexity : O(n + m)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO
from collections import Counter
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        res = []
        l,r = 0,0
        sign = Counter(p)
        count = 0
        while r < len(s):
            inc = s[r]
            # process inc
            if inc in sign:
                sign[inc] -= 1
                if sign[inc] == 0:
                    count += 1
            
            if r >= len(p):
                outc = s[l]
                if outc in sign:
                    sign[outc] += 1
                    if sign[outc] == 1:
                        count -= 1
                l += 1
            
            r += 1
            if count == len(sign):
                res.append(l)

        return res