""""// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        d={}
        for i in p:
            if i not in d:
                d[i]=0
            d[i]+=1

        match=0
        result=[]
        for i in range(len(s)):
            #IN
            if s[i] in d:
                d[s[i]]-=1
                if d[s[i]]==0:
                    match+=1
            #OUT
            if i>=len(p):
                if s[i-len(p)] in d:
                    d[s[i-len(p)]]+=1
                    if d[s[i-len(p)]]==1:
                        match-=1
            if match==len(d):
                result.append(i-len(p)+1)
        return result
