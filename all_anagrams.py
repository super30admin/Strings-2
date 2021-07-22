class Solution:

    def findAnagrams(self, s: str, p: str) -> List[int]:
        """
        keyIdea: create hashmap of string p whre key as element and value as count. iterate over s and by maintaining size of p and keep track of incoming and outgoing element.
        TC: O(max(len(p)+len(s)))
        SC: O(1)
        """
        
        res=[]
        if not s or not p or len(p)>len(s):return res
        
        hashmap={}
        for i in range(len(p)):
            if p[i] in hashmap:
                hashmap[p[i]]+=1
            else:
                hashmap[p[i]]=1
        print(hashmap)
        
        match=0
        for i in range(len(s)):
            
            # incoming/input element
            if s[i] in hashmap:
                hashmap[s[i]] -= 1
                if hashmap[s[i]] == 0:
                    match += 1
            
            # outgoing/output element
            if i >= len(p):
                # for outgoing character
                j = i - len(p)
                if s[j] in hashmap:
                    hashmap[s[j]] += 1
                    if hashmap[s[j]] == 1:
                        match -= 1
            if match==len(hashmap):
                res.append(i-len(p)+1)
       
        return res
                    
            
            
            