'''
time complexity: O(m+n) // m - len(s) , n- len(p)
space complexity: O(n) // len of string p
'''
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        pDict = {}
        for i in range(len(p)):
            if(p[i] not in pDict):
                pDict[p[i]] = 0
            pDict[p[i]]+=1
        
        match = 0
        res = []    
        for i in range(len(s)):
            if(s[i] in pDict):
                pDict[s[i]]-=1
                if pDict[s[i]] == 0:
                    match+=1

            if(i>=len(p)):
                if(s[i-len(p)] in pDict):
                    pDict[s[i-len(p)]]+=1
                    if(pDict[s[i-len(p)]] == 1):
                        match-=1
            if(match==len(pDict)):
                res.append(i-len(p)+1)
        return res
                        
        