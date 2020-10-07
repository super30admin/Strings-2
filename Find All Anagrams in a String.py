
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        #Time: O(S)+O(P)
        #Space: O(1)
        
        if len(s)<len(p):
            return []
        sol=[]
        
        #Buckets of size 26 to store elements of p and sliding window of s respectively
        B_s = [0]*26
        B_p = [0]*26
        
        #add elements of p and first len(p) elements of s
        for i in range(len(p)):
            B_p[ord(p[i])-ord('a')]+=1
            B_s[ord(s[i])-ord('a')]+=1
        i=0
        j=len(p)-1
        count = 0
        
        #check equality of buckets 
        #add new and remove previous element of sliding window in s Bucket
        while j<len(s):
            if count>0:
                B_s[ord(s[j])-ord('a')]+=1
                B_s[ord(curr)-ord('a')]-=1
            if B_p==B_s:
                sol.append(i)
            curr = s[i]
            count+=1
            i+=1
            j+=1
        return sol
            
            