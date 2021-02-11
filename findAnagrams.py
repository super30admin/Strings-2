class Solution:
    '''
    Time Complexity: O(n)
    Space Complexity: O(1), ignoring output and array of length 26.
    '''
    def __init__(self):
        self.prime = []
        i = 2
        # get first 26 prime numbers, lower case english letters
        while(len(self.prime)<26):
            f=0
            for b in range(2, i//2 + 1):
                if(i%b==0):
                    f=1
                    break
            if(f==0):
                self.prime.append(i)
            
            i+=1
        
        
    def findAnagrams(self, s: str, p: str) -> List[int]:
        # create a hashmap with count
        if len(s)==0:
            return []
        if(len(s)<len(p)):
            return []
        x = 1
        for i in p:
            x = x*self.prime[ord(i)-ord('a')]
        
        i=0
        j = len(p)-1
        y=1
        o=[]
        while(j<len(s)):
            if(i==0):
                k=i
                while(k<=j):
                    y = y*self.prime[ord(s[k])-ord('a')]
                    k+=1
            else:
                y = y*self.prime[ord(s[j])-ord('a')]
            if(y==x):
                o.append(i)
            
            y = y//self.prime[ord(s[i])-ord('a')]
            i+=1
            j+=1
        
        return o
