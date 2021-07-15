class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        """Solution using sliding window and hashmap
        Time complexity-O(n)
        Space complexity-O(m)"""
        hashmap={}
        match=0
        arr=[]
        if len(p)>len(s) or not s or not p:
            return 
        for i in range(len(p)):
            if p[i] not in hashmap:
                hashmap[p[i]]=1
            else:
                hashmap[p[i]]+=1
        for i in range(len(s)):
            
            incoming=i
            if s[incoming] in hashmap:
                
                hashmap[s[incoming]]-=1
                if hashmap[s[incoming]]==0:
                    match+=1
            # print(hashmap)  
            if i>=len(p):
                outgoing=i-len(p)
                if s[outgoing] in hashmap:
                    hashmap[s[outgoing]]+=1
                    if hashmap[s[outgoing]]==1:
                        match-=1
            # print(match, hashmap)
            if match==len(hashmap):
                arr.append(i-len(p)+1)
        return arr
        """Brute Force Approach
        Time complexity-O(m*n^2)
        Space complexity-O(1)"""
#         hashVal=self.findAnagram(0,p, len(p))
#         arr=[]
#         for i in range(0, len(s)-len(p)+1):
#             val=self.findAnagram(i,s, len(p))
#             # print(val)
#             if val==hashVal:
#                 arr.append(i)
#         return arr
    
#     def findAnagram(self, i, s, lenp ):
#         result=1
#         primes=[2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101]
#         for j in range(i, i+lenp):
#             result=result*primes[ord(s[j])-97]
#         return result
        