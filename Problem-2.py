#Time Complexity :O(n)
#Space Complexity :O(1) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : No
class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        
        hmap={}
        res=[]
        for i in p:
            if(i in hmap):
                hmap[i]+=1
            else:
                hmap[i]=1
    
        match=0
        for i in range(len(s)):
            #incoming char
            if(s[i] in hmap):
                hmap[s[i]]-=1
                if(hmap[s[i]]==0):
                    match+=1
            
            #outgoing char
            if(i>=len(p)):
                if(s[i-len(p)] in hmap):
                    hmap[s[i-len(p)]]+=1
                    if(hmap[s[i-len(p)]]==1):
                        match-=1
                    
            if(match==len(hmap)):
                res.append(i-len(p)+1)

        return res
            