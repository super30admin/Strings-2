class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        dict1={}
        result=[]
        K=len(p)
        for char in p:
            dict1[char]=dict1.get(char,0)+1
        
        match=0
        for i in range(len(s)):
            in1=s[i]
            if in1 in dict1:
                cnt=dict1.get(in1)-1
                dict1[in1]=cnt
                if cnt==0:
                    match+=1
            if i>=len(p):
                out=s[i-len(p)]
                if out in dict1:
                    cnt=dict1.get(out)+1
                    dict1[out]=cnt
                    if cnt==1:
                        match-=1
            if match==len(dict1):
                result.append(i-len(p)+1)
        return result            
                
        
#time Complexity is O(n)
#Space Complexity is O(1) as the hashmap is of fixed size 
