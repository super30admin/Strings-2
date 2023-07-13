'''
Problem:  Find All Anagrams in a String
Time Complexity: O(n+m), where n is length of s and m is length of p
Space Complexity: O(1)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        run sliding window of length p
        whenever we slide window, add incoming char and remove outgoing character.
'''

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(p)>len(s):
            return []
        dicts = Counter(p)
        match = 0
        result = []

        for i in range(len(p)):
            if s[i] in dicts:
                dicts[s[i]]-=1
                if dicts[s[i]]==0:
                    match+=1
        
        if match==len(dicts):
            result.append(0)

        start = 0
        end = len(p)-1

        while start <len(s) and end <len(s)-1:
            end+=1
            if s[end] in dicts:
                dicts[s[end]]-=1
                if dicts[s[end]]==0:
                    match+=1
            rem = start
            start+=1
            if s[rem] in dicts:
                dicts[s[rem]]+=1
                if dicts[s[rem]]==1:
                    match-=1
            
            if match==len(dicts):
                result.append(start)
        
        return result


