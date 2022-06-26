class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if(len(s)< len(p)):
            return []
        hashmap = dict()
        for i in p:
            if(i not in hashmap):
                hashmap[i]=0
            hashmap[i]+=1
        
        match = 0
        slow = 0
        ans =[]
        for fast in range(len(s)):
            if(s[fast] in hashmap):
                hashmap[s[fast]]-=1
                if(hashmap[s[fast]]==0):
                    match+=1
            if(fast>=len(p)):
                if(s[slow] in hashmap):
                    if(hashmap[s[slow]]==0):
                        match-=1
                    hashmap[s[slow]]+=1
                slow+=1
            if(match==len(hashmap)):
                ans.append(slow)
            
        return ans
                