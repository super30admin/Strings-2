# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        primes=[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,101]
        
        if len(s) < len(p): return []
        pPrime = self.getPrime(p)
        l = 0
        res = []
        currPrime = 0
        

        for r in range(len(s)):
            c = s[r]
            currPrime = currPrime + (primes[ord(c)-96-1] * (ord(c)-96))
            if currPrime == pPrime:
                c = s[l]
                res.append(l)
            if (r-l+1) == len(p):
                c = s[l]
                currPrime = currPrime - (primes[ord(c)-96-1] * (ord(c)-96))
                l += 1
        
        return res

    
    def getPrime(self, s: str)-> int:
        primes=[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,101]
        r = 0
        for c in s:
            r += primes[ord(c)-96-1] * (ord(c)-96)
        return r