#438. Find All Anagrams in a String
"""
Time Complexity : O(n)
Space Complexity : O(1)  #O(26)
"""
class Solution:
     def findAnagrams(self, s: str, p: str) -> List[int]:
        if(len(s)< len(p)):
            return []
        d = dict()
        for i in p:
            if(i not in d):
                d[i]=0
            d[i]+=1

        match = 0
        slow = 0
        ans =[]
        for fast in range(len(s)):
            if(s[fast] in d):
                d[s[fast]]-=1
                if(d[s[fast]]==0):
                     match+=1
            if(fast>=len(p)):
                if(s[slow] in d):
                    if(d[s[slow]]==0):
                        match-=1
                    d[s[slow]]+=1
                slow+=1
            if(match==len(d)):
                 ans.append(slow)

        return ans
