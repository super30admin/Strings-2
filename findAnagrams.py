Time complexity O(n+m)
space is O(1)



class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        d={}
        res=[]
        for i in range(0,len(p)):
            ch=p[i]
            if ch not in d:
                d[ch]=1
            else:
                d[ch]+=1
        match=0
        for i in range(len(s)):
            #incoming character 
            incom_ch=s[i]
            if incom_ch in d:
                cnt=d[incom_ch]
                cnt-=1
                if(cnt==0):
                    match+=1
                d[incom_ch]=cnt
            if(i>=len(p)):
                outgo_ch=s[i-len(p)]
                if outgo_ch in d:
                    cnt=d[outgo_ch]
                    cnt+=1
                    if(cnt==1):
                        match-=1
                    d[outgo_ch]=cnt
            if(match==len(d)):
                res.append(i-len(p)+1)
            
        return res    
            
            
        