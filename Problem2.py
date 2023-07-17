# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#  
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(p) > len(s) or not p or not s:
            return []
        ref = self.getCode(p)
        code = [0] * 26
        res = []
        for i in range(0, len(p)):
            code[ord(s[i])-97] += 1
        if tuple(code) == ref:
            res.append(0)
        plen = len(p)
        for i in range(plen, len(s)):
            code[ord(s[i])-97] += 1
            code[ord(s[i-plen])-97] -= 1
            if tuple(code) == ref:
                res.append(i-plen+1)    
        return res


    def getCode(self, p):
        res = [0] * 26
        for ch in p:
            res[ord(ch)-97] += 1
        return tuple(res)