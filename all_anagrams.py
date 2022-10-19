#Time Complexity - O(m+n)
#Space Complexcity - O(1)

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        #If length of pattern is more then return an empty list
        if len(p)>len(s):
            return []
        
        #Create a map and res array
        pattern={} 
        res=[]
        match=0
        
        #Put the pattern in the map
        for i in range(len(p)):
            pattern[p[i]]=1+pattern.get(p[i],0)
            
        
        #Now iterate through the stirng and check for incoming and outgoin character
        for r in range(len(s)):
            
            #Incoming Character
            if s[r] in pattern:
                #Take the counted value and if it is in the pattern 
                #Then reduce the count
                count=pattern[s[r]]
                count-=1
                pattern[s[r]]=count
                if count==0:
                    match+=1
            
            #Outgoing Character
            if r>=len(p):
                #Get the last character
                out=r-len(p)
                if s[out] in pattern:
                    count=pattern[s[out]]
                    count+=1
                    pattern[s[out]]=count
                
                    if count==1:
                        match-=1
                        
            if match==len(pattern):
                res.append(r-len(p)+1)
        return res