# Time Complexity : O(m+n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(s)==0 or len(p)==0 or len(s)<len(p): 
            return []
        
        result = []
        
        hashmap_p = {}
        
        for i in p:
            if i not in hashmap_p:
                hashmap_p[i]=1
            else:
                hashmap_p[i]+=1
        
        match = 0
        
        for i in range(len(s)):
            inc = s[i]
            
            if inc in hashmap_p:
                count = hashmap_p[inc]
                count-=1
                
                if count==0:
                    match+=1
                hashmap_p[inc] = count
                
            if i>=len(p):
                out = s[i-len(p)]
                if out in hashmap_p:
                    count = hashmap_p[out]
                    count+=1
                
                    if count==1:
                        match-=1
                    hashmap_p[out] = count

            if match==len(hashmap_p):
                result.append(i-len(p)+1)
        return result