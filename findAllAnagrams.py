#Time complexity: O(n)
#Space complexity: O(1)
class Solution:
    def findAnagrams(self, s: str, p: str):
        dict1={}
        for i in p:
            if i not in dict1:
                dict1[i]=0
            dict1[i]+=1
        matchcount=0
        res=[]
        for i in range(len(s)):
            if s[i] in dict1:
                dict1[s[i]]-=1
                if dict1[s[i]]==0:
                    matchcount+=1
                
            if i>=len(p):
                out_char=s[i-len(p)]
                if out_char in dict1:
                    dict1[out_char]+=1
                    if dict1[out_char]==1:
                        matchcount-=1
            if matchcount==len(dict1):
                res.append(i-len(p)+1)
        return res
                
        