class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:

        #Methdo 1 - Brute force - geenrate all substrings of len(p) and do hashmap check -> O(m*n) for TC and O(1) for SC

        #Method 2 - Sliding Window - TC O(m+n) and O(1) for SC
        d={}
        n=len(p)
        for i in range(n):
            d[p[i]]=d.get(p[i],0)+1
        match=0
        res=[]
        for i in range(len(s)):
            incoming=s[i]
            if incoming in d: #everytime we take the next character in by default
                d[incoming]-=1
                if d[incoming]==0:
                    match+=1
            if i>=n: #once building a window of len n, we remove right most element from the sliding window hence i>=n
                outgoing=s[i-n] #right most
                if outgoing in d: 
                    d[outgoing]+=1
                    if d[outgoing]==1: #the moment it becomes 1 from 0, that means we lost a character, so match-=1
                        match-=1
            if match==len(d): #if everything is 0, we have an anagram
                res.append(i-n+1)
        return res

