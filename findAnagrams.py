class Solution:
    def findAnagrams(self,s,p):
        n,m=len(s),len(p)
        if m>n:
            return[]
        
        need=[0]*26
        window=[0]*26

        for ch in p:
            need[ord(ch)-ord('a')]+=1
        
        res=[]
        for i in range(m):
            window[ord(s[i])-ord('a')]+=1
        if window==need:
            res.append(0)
        
        for i in range(m,n):
            window[ord(s[i-m])-ord('a')]-=1
            window[ord(s[i])-ord('a')]+=1
            if window==need:
                res.append(i-m+1)

        return res

sol=Solution()   
print(sol.findAnagrams("cbaebabacd","abc"))
print(sol.findAnagrams("abab", "ab"))

