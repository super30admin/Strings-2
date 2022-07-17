# time comlexity is o(n), where n is the size of the input
# space complexity is o(26), which is constant, so space is o(1)
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        d = dict() #space is o(26), which is constant, space is o(1)
        match = 0
        res = list()
        for i in p: #time is o(n)
            if(i not in d):
                d[i] = 0
            d[i] += 1
        
        for i in range(len(s)):
            if(i < len(p)):
                if(s[i] in d):
                    d[s[i]] -= 1
                    if(d[s[i]] == 0):
                        match += 1
                if(match == len(d)):
                    res.append(i - len(p) + 1)
            if(i >= len(p)):
                if(s[i] in d):
                    d[s[i]] -= 1
                    if(d[s[i]] == 0):
                        match += 1
                if(s[i-len(p)] in d):
                    d[s[i-len(p)]] += 1
                    if(d[s[i-len(p)]] == 1):
                        match -= 1
                if(match == len(d)):
                    res.append(i - len(p) + 1)
        return res
                
                    
            
        
        
#         Brute force TLE 
#         dp = dict()
#         for i in p:
#             if(i not in dp):
#                 dp[i] = 0
#             dp[i] += 1
                
#         res = list()
#         # pset.add(k)
#         lp = len(p)
#         ls = len(s)
#         for i in range(ls - lp + 1):
#             flag = True
#             dj = dict()
#             for j in s[i:i+lp]:
#                 if(j not in dj):
#                     dj[j] = 0
#                 dj[j] += 1
#             for key in dj:
#                 if(key not in dp or dp[key] != dj[key]):
#                     flag = False
#                     break
#             if(flag):
#                 res.append(i)
#         return res
                       
        