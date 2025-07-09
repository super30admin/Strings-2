# TimeComplexity:O(M+N)
# SpaceCompelity:O(1)

# Approach:
# Brute force would be  add to hashmap and everytime comapre hashmap
# Optimal is doing sliding window and using match_count(common in string with sliding wondow)
# first add freq of ele inp to dict and traveser through s if you find any char in s that is in freq_dict,dec count by 1 and if freq becomes 0 after decreading  increase match count by 1
# this is for incoming ,and for outgoing idx should be more than p then see if outgoing is in freqdict ..then increse count by 1 and if freq is 0 before updating then dec match count by 1
# at any point if match count is k which is same as number of keys in freq dict add idx to ans
#---------------------------------
#Optimal
#---------------------------------

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        #use single hashmap ..
        # 1. add all ele of p in hashmap
        # 2.maitain a slding window if in hahmpain c count if incoming ..if out going dec count by 1
        pdict=dict()
        ans=[]
        match_count=0
        m=len(p)
        for i in p:
            if i in pdict:
                pdict[i]+=1
            else:
                pdict[i]=1
        k=len(pdict.keys())
        for idx in range(len(s)):
            #incoming
            if s[idx] in pdict:
                pdict[s[idx]]-=1
                if pdict[s[idx]]==0:
                    match_count+=1
            #outgoing
            if idx>=m:
                if s[idx-m] in pdict:
                    if pdict[s[idx-m]]==0:match_count-=1
                    pdict[s[idx-m]]+=1
                    
            #checking match count
            if match_count==k:
                ans.append(idx+1-m)
        return ans




#---------------------------------
#Gives TLE
#---------------------------------

from collections import defaultdict
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        d1,d2=defaultdict(int),defaultdict(int)
        for i in p :
            d1[i]=d1[i]+1
            d2[i]=0
        if len(p)>len(s):return []
        l=0
        r=l+len(p)-1
        ans=[]
        for i in range(len(p)):
            if s[i] in d1:
                d2[s[i]]+=1
            else:
                break
       
        if d1!=d2:
            for i in d2:
                d2[i]=0
        if d1==d2:
            ans.append(l)
            l+=1
            r+=1
       
        #update l and r again
        while(l<len(s)  and r<len(s)):
            
            if s[l] in  d1 and r<len(s) and s[r] in d1:
                dk=defaultdict(int)

                for i in range(l,r+1):
                    dk[s[i]]=dk[s[i]]+1
                    

                if d1==dk:
                    ans.append(l)
                l+=1
                r+=1
                
            else:
                l+=1
                r+=1
        return ans

                
            
            # while(l<len(s) and s[l] not in d1):
            #     l+=1
            #     r+=1

            


        
